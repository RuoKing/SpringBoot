
package spring.SpringBoot.listener;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import spring.SpringBoot.entry.RaffleInfo;

import java.util.Map;

    @Controller
    @RequestMapping("/api/listener")
    public class ListenTransaction {

        @RequestMapping("/listen-transaction")
        public void listenTransaction(@RequestParam Map<String,Object> map) {
            // 在这里启动新的线程来监听交易状态new Thread(() -> {
            new Thread(() -> {
                try {
                    TransactionListener listener = new TransactionListener(map);
                    listener.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 在这里使用Web3j或The Graph等库来监听交易状态
            }).start();
        }



    }
