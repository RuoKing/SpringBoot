package spring.SpringBoot.listener;


import org.springframework.beans.factory.annotation.Autowired;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthTransaction;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;
import spring.SpringBoot.constant.Constant;
import spring.SpringBoot.entry.ParticipantInfo;
import spring.SpringBoot.entry.RaffleInfo;
import spring.SpringBoot.mapper.RaffleInfoMapper;
import spring.SpringBoot.mapper.TokenInfoMapper;
import spring.SpringBoot.service.ParticipantInfoService;
import spring.SpringBoot.service.RaffleInfoService;
import spring.SpringBoot.solidity.NRaffle;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TransactionListener {
    private final String txHash;
    private final Web3j web3j;
    private final ScheduledExecutorService executorService;


    private Map<String, Object> map;


    ParticipantInfoService participantInfoService;

    @Autowired
    RaffleInfoService raffleInfoService;

    TokenInfoMapper tokenInfoMapper;

    RaffleInfoMapper raffleInfoMapper;

    public TransactionListener(Map<String, Object> map, ParticipantInfoService participantInfoService,
                               TokenInfoMapper tokenInfoMapper,
                               RaffleInfoMapper raffleInfoMapper) {
        txHash = map.get("txHash").toString();
        this.map = map;
        web3j = Web3j.build(new HttpService(Constant.SEPOLIAURL));
        this.participantInfoService = participantInfoService;
        this.tokenInfoMapper = tokenInfoMapper;
        this.raffleInfoMapper = raffleInfoMapper;
        this.executorService = Executors.newSingleThreadScheduledExecutor();
    }

    public void start() {
        executorService.scheduleAtFixedRate(() -> {
            try {
                EthTransaction ethTransaction = web3j.ethGetTransactionByHash(txHash).send();
                Transaction transaction = ethTransaction.getTransaction().orElse(null);
                if (transaction != null) {
                    EthGetTransactionReceipt ethGetTransactionReceipt = web3j.ethGetTransactionReceipt(txHash).send();
                    if (ethGetTransactionReceipt.getTransactionReceipt().isPresent()) {
                        TransactionReceipt transactionReceipt = ethGetTransactionReceipt.getTransactionReceipt().get();
                        if (("0x0").equals(transactionReceipt.getStatus())) {
                            // 交易确认失败，不做任何操作，中断线程
                            System.out.println(Thread.currentThread().getId() + "Transaction confirmed: " + txHash);
                            executorService.shutdown();
                        } else {
                            // 交易成功
                            System.out.println(Thread.currentThread().getId() + "Transaction failed: " + txHash);
                            //区块确认后，获得交易详情，获得 raffleAddress
//                            Object result = web3j.ethGetTransactionByHash(txHash).send().getTransaction().orElseThrow(TransactionException::new);
                            //根据交易类型不同，调用不同的方法

                            switch (map.get("op").toString()) {
                                case "verifyNFTPresenceBeforeStart":
                                    verifyNFTPresenceBeforeStart(map.get("newOwner").toString());
                                    //这里报错了
                                    tokenInfoMapper.updateOwnerInt(map.get("newOwner").toString(),map.get("TokenContractAddress").toString(),map.get("tokenId").toString());
                                    break;
                                case "TicketsPurchased":
                                    ParticipantInfo participantInfo = new ParticipantInfo();
                                    participantInfo.setParticipantAddress(map.get("participantAddress").toString());
                                    participantInfo.setRaffleaddress(map.get("raffleAddress").toString());
                                    participantInfo.setTicket(Integer.valueOf(map.get("ticketNum").toString()));
                                    participantInfoService.createParticipantInfo(participantInfo);
                                    break;
                                case "UpdateTokenOwner":
                                    tokenInfoMapper.updateOwnerInt(map.get("newOwner").toString(),map.get("TokenContractAddress").toString(),map.get("tokenId").toString());
                                    RaffleInfo raffleInfo = null;
                                    raffleInfo.setSwapStatus(Integer.parseInt(map.get("swapStatus").toString()));
                                    raffleInfo.setRaffleaddress(map.get("raffleAddress").toString());
                                    raffleInfoMapper.updateRaffleInfo(raffleInfo);
                                    break;
                                case "UpdateSwapStatus":
                                    RaffleInfo raffleInfo1 = new RaffleInfo();
                                    raffleInfo1.setSwapStatus(Integer.parseInt(map.get("swapStatus").toString()));
                                    raffleInfo1.setRaffleaddress(map.get("raffleaddress").toString());
                                    raffleInfoMapper.updateRaffleInfo(raffleInfo1);
                                    break;
                                default:
                                    System.out.println("Unknown fruit selected");
                            }
                            executorService.shutdown();
                        }
                    }
                }
            } catch (Exception e) {
                // 异常处理
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId() + "Transaction error: " + txHash);
        }, 0, 5, TimeUnit.SECONDS);
    }

    private void verifyNFTPresenceBeforeStart(String address) {

        Web3j web3 = Web3j.build(new HttpService(Constant.SEPOLIAURL));
        //私钥
        Credentials credentials = Credentials.create(Constant.PRIVATEKEY);
        BigInteger gasPrice = null;
        try {
            gasPrice = web3.ethGasPrice().send().getGasPrice();
        } catch (IOException e) {
            e.printStackTrace();
        }
        NRaffle NRaffleContract = NRaffle.load(address, web3, credentials,
                new StaticGasProvider(gasPrice, BigInteger.valueOf(Constant.GASPRICE)));
        System.out.println("verifyNFTPresenceBeforeStart方法内执行");


        RemoteFunctionCall<TransactionReceipt> verifyNFT = NRaffleContract.verifyNFTPresenceBeforeStart();
        TransactionReceipt transactionReceipt = null;
        try {
            transactionReceipt = verifyNFT.sendAsync().get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

//    public TransactionListener(RaffleInfo raffleInfo, Web3j web3j) throws IOException {
//        this.txHash = raffleInfo.getTxHash();
//        this.raffleInfo = raffleInfo;
//        this.web3j = web3j;
//        this.executorService = Executors.newSingleThreadScheduledExecutor();
//    }
//
//    public void start() {
//        executorService.scheduleAtFixedRate(() -> {
//            try {
//                EthTransaction ethTransaction = web3j.ethGetTransactionByHash(txHash).send();
//                Transaction transaction = ethTransaction.getTransaction().orElse(null);
//                if (transaction != null) {
//                    EthGetTransactionReceipt ethGetTransactionReceipt = web3j.ethGetTransactionReceipt(txHash).send();
//                    if (ethGetTransactionReceipt.getTransactionReceipt().isPresent()) {
//                        TransactionReceipt transactionReceipt = ethGetTransactionReceipt.getTransactionReceipt().get();
//                        if (transactionReceipt.getStatus().equals("0x0")) {
//                            // 交易确认失败，不做任何操作，中断线程
//                            System.out.println(Thread.currentThread().getId() + "Transaction confirmed: " + txHash);
//                            executorService.shutdown();
//                        } else {
//                            // 交易成功
//                            System.out.println(Thread.currentThread().getId() + "Transaction failed: " + txHash);
//                            //区块确认后，获得交易详情，获得 raffleAddress
////                            Object result = web3j.ethGetTransactionByHash(txHash).send().getTransaction().orElseThrow(TransactionException::new);
//                            //根据交易类型不同，调用不同的方法
//
//                            executorService.shutdown();
//                        }
//                    }
//                }
//            } catch (Exception e) {
//                // 异常处理
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getId() + "Transaction error: " + txHash);
//        }, 0, 5, TimeUnit.SECONDS);
//    }
//}


