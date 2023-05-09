package spring.SpringBoot.solidity;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint16;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 5.0.0.
 */
@SuppressWarnings("rawtypes")
public class NRaffleFactory extends Contract {
    public static final String BINARY = "{\"linkReferences\": {},\n"
            + "   \"object\": \"608060405234801561001057600080fd5b50600436106100415760003560e01c80632e64cec1146100465780635c3fdcd9146100645780636057361d14610082575b600080fd5b61004e61009e565b60405161005b9190610118565b60405180910390f35b61006c6100a7565b604051610079919061014f565b60405180910390f35b61009c6004803603810190610097919061019b565b6100be565b005b60008054905090565b6000600160009054906101000a900460ff16905090565b806000819055507f93fe6d397c74fdf1402a8b72e47b68512f0510d7b98a4bc4cbdf6ac7108b3c59816040516100f49190610118565b60405180910390a150565b6000819050919050565b610112816100ff565b82525050565b600060208201905061012d6000830184610109565b92915050565b600060ff82169050919050565b61014981610133565b82525050565b60006020820190506101646000830184610140565b92915050565b600080fd5b610178816100ff565b811461018357600080fd5b50565b6000813590506101958161016f565b92915050565b6000602082840312156101b1576101b061016a565b5b60006101bf84828501610186565b9150509291505056fea2646970667358221220560a396990a6636d6adc0b948c3280f5b89a2c74a19fd9acc43c04401df2bba264736f6c63430008120033\",\n"
            + "   \"opcodes\": \"PUSH1 0x80 PUSH1 0x40 MSTORE CALLVALUE DUP1 ISZERO PUSH2 0x10 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH1 0x4 CALLDATASIZE LT PUSH2 0x41 JUMPI PUSH1 0x0 CALLDATALOAD PUSH1 0xE0 SHR DUP1 PUSH4 0x2E64CEC1 EQ PUSH2 0x46 JUMPI DUP1 PUSH4 0x5C3FDCD9 EQ PUSH2 0x64 JUMPI DUP1 PUSH4 0x6057361D EQ PUSH2 0x82 JUMPI JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH2 0x4E PUSH2 0x9E JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x5B SWAP2 SWAP1 PUSH2 0x118 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH2 0x6C PUSH2 0xA7 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x79 SWAP2 SWAP1 PUSH2 0x14F JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH2 0x9C PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x97 SWAP2 SWAP1 PUSH2 0x19B JUMP JUMPDEST PUSH2 0xBE JUMP JUMPDEST STOP JUMPDEST PUSH1 0x0 DUP1 SLOAD SWAP1 POP SWAP1 JUMP JUMPDEST PUSH1 0x0 PUSH1 0x1 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND SWAP1 POP SWAP1 JUMP JUMPDEST DUP1 PUSH1 0x0 DUP2 SWAP1 SSTORE POP PUSH32 0x93FE6D397C74FDF1402A8B72E47B68512F0510D7B98A4BC4CBDF6AC7108B3C59 DUP2 PUSH1 0x40 MLOAD PUSH2 0xF4 SWAP2 SWAP1 PUSH2 0x118 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 LOG1 POP JUMP JUMPDEST PUSH1 0x0 DUP2 SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH2 0x112 DUP2 PUSH2 0xFF JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP PUSH2 0x12D PUSH1 0x0 DUP4 ADD DUP5 PUSH2 0x109 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0xFF DUP3 AND SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH2 0x149 DUP2 PUSH2 0x133 JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP PUSH2 0x164 PUSH1 0x0 DUP4 ADD DUP5 PUSH2 0x140 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH2 0x178 DUP2 PUSH2 0xFF JUMP JUMPDEST DUP2 EQ PUSH2 0x183 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP JUMP JUMPDEST PUSH1 0x0 DUP2 CALLDATALOAD SWAP1 POP PUSH2 0x195 DUP2 PUSH2 0x16F JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 DUP5 SUB SLT ISZERO PUSH2 0x1B1 JUMPI PUSH2 0x1B0 PUSH2 0x16A JUMP JUMPDEST JUMPDEST PUSH1 0x0 PUSH2 0x1BF DUP5 DUP3 DUP6 ADD PUSH2 0x186 JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP INVALID LOG2 PUSH5 0x6970667358 0x22 SLT KECCAK256 JUMP EXP CODECOPY PUSH10 0x90A6636D6ADC0B948C32 DUP1 CREATE2 0xB8 SWAP11 0x2C PUSH21 0xA19FD9ACC43C04401DF2BBA264736F6C6343000812 STOP CALLER \",\n"
            + "   \"sourceMap\": \"78:556:0:-:0;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;427:80;;;:::i;:::-;;;;;;;:::i;:::-;;;;;;;;543:85;;;:::i;:::-;;;;;;;:::i;:::-;;;;;;;;284:102;;;;;;;;;;;;;:::i;:::-;;:::i;:::-;;427:80;468:7;494:6;;487:13;;427:80;:::o;543:85::-;582:5;610:7;;;;;;;;;;;603:14;;543:85;:::o;284:102::-;340:5;331:6;:14;;;;360:19;373:5;360:19;;;;;;:::i;:::-;;;;;;;;284:102;:::o;7:77:1:-;44:7;73:5;62:16;;7:77;;;:::o;90:118::-;177:24;195:5;177:24;:::i;:::-;172:3;165:37;90:118;;:::o;214:222::-;307:4;345:2;334:9;330:18;322:26;;358:71;426:1;415:9;411:17;402:6;358:71;:::i;:::-;214:222;;;;:::o;442:86::-;477:7;517:4;510:5;506:16;495:27;;442:86;;;:::o;534:112::-;617:22;633:5;617:22;:::i;:::-;612:3;605:35;534:112;;:::o;652:214::-;741:4;779:2;768:9;764:18;756:26;;792:67;856:1;845:9;841:17;832:6;792:67;:::i;:::-;652:214;;;;:::o;953:117::-;1062:1;1059;1052:12;1199:122;1272:24;1290:5;1272:24;:::i;:::-;1265:5;1262:35;1252:63;;1311:1;1308;1301:12;1252:63;1199:122;:::o;1327:139::-;1373:5;1411:6;1398:20;1389:29;;1427:33;1454:5;1427:33;:::i;:::-;1327:139;;;;:::o;1472:329::-;1531:6;1580:2;1568:9;1559:7;1555:23;1551:32;1548:119;;;1586:79;;:::i;:::-;1548:119;1706:1;1731:53;1776:7;1767:6;1756:9;1752:22;1731:53;:::i;:::-;1721:63;;1677:117;1472:329;;;;:::o\"\n"
            + "  }";

    public static final String FUNC_CREATOR_ROLE = "CREATOR_ROLE";

    public static final String FUNC_DEFAULT_ADMIN_ROLE = "DEFAULT_ADMIN_ROLE";

    public static final String FUNC_CREATERAFFLE = "createRaffle";

    public static final String FUNC_GETCREATERAFFLEFEE = "getCreateRaffleFee";

    public static final String FUNC_GETOFFICESERVICERATIO = "getOfficeServiceRatio";

    public static final String FUNC_GETOWNERREWARDRATIO = "getOwnerRewardRatio";

    public static final String FUNC_GETRAFFLE = "getRaffle";

    public static final String FUNC_GETRAFFLECOUNT = "getRaffleCount";

    public static final String FUNC_GETROLEADMIN = "getRoleAdmin";

    public static final String FUNC_GETSWAPDURATION = "getSwapDuration";

    public static final String FUNC_GRANTROLE = "grantRole";

    public static final String FUNC_HASROLE = "hasRole";

    public static final String FUNC_RENOUNCEROLE = "renounceRole";

    public static final String FUNC_REVOKEROLE = "revokeRole";

    public static final String FUNC_SETCREATERAFFLEFEE = "setCreateRaffleFee";

    public static final String FUNC_SETOFFICESERVICERATIO = "setOfficeServiceRatio";

    public static final String FUNC_SETOWNERREWARDRATIO = "setOwnerRewardRatio";

    public static final String FUNC_SETSWAPDURATION = "setSwapDuration";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final Event RAFFLECREATED_EVENT = new Event("RaffleCreated",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Address>() {
            }, new TypeReference<Uint256>() {
            }, new TypeReference<Uint256>() {
            }, new TypeReference<Uint16>() {
            }, new TypeReference<Uint256>() {
            }, new TypeReference<Uint256>() {
            }, new TypeReference<Uint256>() {
            }, new TypeReference<Address>() {
            }, new TypeReference<Bytes32>() {
            }, new TypeReference<Address>(true) {
            }));
    ;

    public static final Event ROLEADMINCHANGED_EVENT = new Event("RoleAdminChanged",
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {
            }, new TypeReference<Bytes32>(true) {
            }, new TypeReference<Bytes32>(true) {
            }));
    ;

    public static final Event ROLEGRANTED_EVENT = new Event("RoleGranted",
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }));
    ;

    public static final Event ROLEREVOKED_EVENT = new Event("RoleRevoked",
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }));
    ;

    @Deprecated
    protected NRaffleFactory(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected NRaffleFactory(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected NRaffleFactory(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected NRaffleFactory(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<RaffleCreatedEventResponse> getRaffleCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RAFFLECREATED_EVENT, transactionReceipt);
        ArrayList<RaffleCreatedEventResponse> responses = new ArrayList<RaffleCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RaffleCreatedEventResponse typedResponse = new RaffleCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.raffleAddress = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.nftContract = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.nftTokenId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.nftStandardId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.tickets = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.ticketPrice = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.startTimestamp = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.endTimestamp = (BigInteger) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse.vrfCoordinator = (String) eventValues.getNonIndexedValues().get(7).getValue();
            typedResponse.vrfKeyHash = (byte[]) eventValues.getNonIndexedValues().get(8).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RaffleCreatedEventResponse> raffleCreatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RaffleCreatedEventResponse>() {
            @Override
            public RaffleCreatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RAFFLECREATED_EVENT, log);
                RaffleCreatedEventResponse typedResponse = new RaffleCreatedEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.raffleAddress = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.nftContract = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.nftTokenId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.nftStandardId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.tickets = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.ticketPrice = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.startTimestamp = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.endTimestamp = (BigInteger) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse.vrfCoordinator = (String) eventValues.getNonIndexedValues().get(7).getValue();
                typedResponse.vrfKeyHash = (byte[]) eventValues.getNonIndexedValues().get(8).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RaffleCreatedEventResponse> raffleCreatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RAFFLECREATED_EVENT));
        return raffleCreatedEventFlowable(filter);
    }

    public List<RoleAdminChangedEventResponse> getRoleAdminChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ROLEADMINCHANGED_EVENT, transactionReceipt);
        ArrayList<RoleAdminChangedEventResponse> responses = new ArrayList<RoleAdminChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RoleAdminChangedEventResponse typedResponse = new RoleAdminChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.previousAdminRole = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.newAdminRole = (byte[]) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RoleAdminChangedEventResponse> roleAdminChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RoleAdminChangedEventResponse>() {
            @Override
            public RoleAdminChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ROLEADMINCHANGED_EVENT, log);
                RoleAdminChangedEventResponse typedResponse = new RoleAdminChangedEventResponse();
                typedResponse.log = log;
                typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.previousAdminRole = (byte[]) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.newAdminRole = (byte[]) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RoleAdminChangedEventResponse> roleAdminChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ROLEADMINCHANGED_EVENT));
        return roleAdminChangedEventFlowable(filter);
    }

    public List<RoleGrantedEventResponse> getRoleGrantedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ROLEGRANTED_EVENT, transactionReceipt);
        ArrayList<RoleGrantedEventResponse> responses = new ArrayList<RoleGrantedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RoleGrantedEventResponse typedResponse = new RoleGrantedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RoleGrantedEventResponse> roleGrantedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RoleGrantedEventResponse>() {
            @Override
            public RoleGrantedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ROLEGRANTED_EVENT, log);
                RoleGrantedEventResponse typedResponse = new RoleGrantedEventResponse();
                typedResponse.log = log;
                typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RoleGrantedEventResponse> roleGrantedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ROLEGRANTED_EVENT));
        return roleGrantedEventFlowable(filter);
    }

    public List<RoleRevokedEventResponse> getRoleRevokedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ROLEREVOKED_EVENT, transactionReceipt);
        ArrayList<RoleRevokedEventResponse> responses = new ArrayList<RoleRevokedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RoleRevokedEventResponse typedResponse = new RoleRevokedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RoleRevokedEventResponse> roleRevokedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RoleRevokedEventResponse>() {
            @Override
            public RoleRevokedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ROLEREVOKED_EVENT, log);
                RoleRevokedEventResponse typedResponse = new RoleRevokedEventResponse();
                typedResponse.log = log;
                typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RoleRevokedEventResponse> roleRevokedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ROLEREVOKED_EVENT));
        return roleRevokedEventFlowable(filter);
    }

    public RemoteFunctionCall<byte[]> CREATOR_ROLE() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CREATOR_ROLE,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {
                }));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> DEFAULT_ADMIN_ROLE() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DEFAULT_ADMIN_ROLE,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {
                }));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> createRaffle(String owner, String nftContract, BigInteger nftTokenId, BigInteger nftStandardId, BigInteger tickets, BigInteger ticketPrice, BigInteger startTimestamp, BigInteger endTimestamp, byte[] vrfKeyHash, BigInteger linkAmount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CREATERAFFLE,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner),
                        new org.web3j.abi.datatypes.Address(160, nftContract),
                        new org.web3j.abi.datatypes.generated.Uint256(nftTokenId),
                        new org.web3j.abi.datatypes.generated.Uint256(nftStandardId),
                        new org.web3j.abi.datatypes.generated.Uint16(tickets),
                        new org.web3j.abi.datatypes.generated.Uint256(ticketPrice),
                        new org.web3j.abi.datatypes.generated.Uint256(startTimestamp),
                        new org.web3j.abi.datatypes.generated.Uint256(endTimestamp),
                        new org.web3j.abi.datatypes.generated.Bytes32(vrfKeyHash),
                        new org.web3j.abi.datatypes.generated.Uint256(linkAmount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getCreateRaffleFee() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCREATERAFFLEFEE,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
                }));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getOfficeServiceRatio() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETOFFICESERVICERATIO,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint16>() {
                }));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getOwnerRewardRatio() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETOWNERREWARDRATIO,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint16>() {
                }));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getRaffle(BigInteger index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETRAFFLE,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
                }));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getRaffleCount() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETRAFFLECOUNT,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
                }));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> getRoleAdmin(byte[] role) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETROLEADMIN,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {
                }));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> getSwapDuration() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETSWAPDURATION,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
                }));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> grantRole(byte[] role, String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_GRANTROLE,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role),
                        new org.web3j.abi.datatypes.Address(160, account)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> hasRole(byte[] role, String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_HASROLE,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role),
                        new org.web3j.abi.datatypes.Address(160, account)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {
                }));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceRole(byte[] role, String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RENOUNCEROLE,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role),
                        new org.web3j.abi.datatypes.Address(160, account)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> revokeRole(byte[] role, String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REVOKEROLE,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role),
                        new org.web3j.abi.datatypes.Address(160, account)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setCreateRaffleFee(BigInteger createRaffleFee) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETCREATERAFFLEFEE,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(createRaffleFee)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setOfficeServiceRatio(BigInteger officeServiceRatio) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETOFFICESERVICERATIO,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint16(officeServiceRatio)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setOwnerRewardRatio(BigInteger ownerRewardRatio) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETOWNERREWARDRATIO,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint16(ownerRewardRatio)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setSwapDuration(BigInteger swapDuration) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETSWAPDURATION,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(swapDuration)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> supportsInterface(byte[] interfaceId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SUPPORTSINTERFACE,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {
                }));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> withdraw(BigInteger amount, String to) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_WITHDRAW,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount),
                        new org.web3j.abi.datatypes.Address(160, to)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static NRaffleFactory load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new NRaffleFactory(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static NRaffleFactory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new NRaffleFactory(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static NRaffleFactory load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new NRaffleFactory(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static NRaffleFactory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new NRaffleFactory(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<NRaffleFactory> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger officeServiceRatio, BigInteger ownerRewardRatio, BigInteger createRaffleFee, String link_token_contract, String vrfCoordinator) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint16(officeServiceRatio),
                new org.web3j.abi.datatypes.generated.Uint16(ownerRewardRatio),
                new org.web3j.abi.datatypes.generated.Uint256(createRaffleFee),
                new org.web3j.abi.datatypes.Address(160, link_token_contract),
                new org.web3j.abi.datatypes.Address(160, vrfCoordinator)));
        return deployRemoteCall(NRaffleFactory.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<NRaffleFactory> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger officeServiceRatio, BigInteger ownerRewardRatio, BigInteger createRaffleFee, String link_token_contract, String vrfCoordinator) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint16(officeServiceRatio),
                new org.web3j.abi.datatypes.generated.Uint16(ownerRewardRatio),
                new org.web3j.abi.datatypes.generated.Uint256(createRaffleFee),
                new org.web3j.abi.datatypes.Address(160, link_token_contract),
                new org.web3j.abi.datatypes.Address(160, vrfCoordinator)));
        return deployRemoteCall(NRaffleFactory.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<NRaffleFactory> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger officeServiceRatio, BigInteger ownerRewardRatio, BigInteger createRaffleFee, String link_token_contract, String vrfCoordinator) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint16(officeServiceRatio),
                new org.web3j.abi.datatypes.generated.Uint16(ownerRewardRatio),
                new org.web3j.abi.datatypes.generated.Uint256(createRaffleFee),
                new org.web3j.abi.datatypes.Address(160, link_token_contract),
                new org.web3j.abi.datatypes.Address(160, vrfCoordinator)));
        return deployRemoteCall(NRaffleFactory.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<NRaffleFactory> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger officeServiceRatio, BigInteger ownerRewardRatio, BigInteger createRaffleFee, String link_token_contract, String vrfCoordinator) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint16(officeServiceRatio),
                new org.web3j.abi.datatypes.generated.Uint16(ownerRewardRatio),
                new org.web3j.abi.datatypes.generated.Uint256(createRaffleFee),
                new org.web3j.abi.datatypes.Address(160, link_token_contract),
                new org.web3j.abi.datatypes.Address(160, vrfCoordinator)));
        return deployRemoteCall(NRaffleFactory.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class RaffleCreatedEventResponse extends BaseEventResponse {
        public String owner;

        public String raffleAddress;

        public String nftContract;

        public BigInteger nftTokenId;

        public BigInteger nftStandardId;

        public BigInteger tickets;

        public BigInteger ticketPrice;

        public BigInteger startTimestamp;

        public BigInteger endTimestamp;

        public String vrfCoordinator;

        public byte[] vrfKeyHash;

        @Override
        public String toString() {
            return "RaffleCreatedEventResponse{" +
                    "owner='" + owner + '\'' +
                    ", raffleAddress='" + raffleAddress + '\'' +
                    ", nftContract='" + nftContract + '\'' +
                    ", nftTokenId=" + nftTokenId +
                    ", nftStandardId=" + nftStandardId +
                    ", tickets=" + tickets +
                    ", ticketPrice=" + ticketPrice +
                    ", startTimestamp=" + startTimestamp +
                    ", endTimestamp=" + endTimestamp +
                    '}';
        }
    }

    public static class RoleAdminChangedEventResponse extends BaseEventResponse {
        public byte[] role;

        public byte[] previousAdminRole;

        public byte[] newAdminRole;
    }

    public static class RoleGrantedEventResponse extends BaseEventResponse {
        public byte[] role;

        public String account;

        public String sender;
    }

    public static class RoleRevokedEventResponse extends BaseEventResponse {
        public byte[] role;

        public String account;

        public String sender;
    }
}
