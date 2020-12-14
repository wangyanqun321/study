package com.wyq.socket;

/**
 * @author 王艳群
 * @description SoketTest
 * @date 2020/6/3
 */

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.stream.IntStream;

public class SocketServer {
    public static void main(String[] args) throws Exception {
        // 监听指定的端口
        int port = 9000;
        ServerSocket server = new ServerSocket(port);

        // server将一直等待连接的到来
        System.out.println("server将一直等待连接的到来");

        Socket socket = server.accept();
        System.out.println("建立连接");
        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        OutputStream outputStream = socket.getOutputStream();
        IntStream.range(0, 10).forEach(i -> {
            try {
                System.out.println(i);
                outputStream.write((i + ",中国," + i).getBytes(StandardCharsets.UTF_8));
               // outputStream.flush();
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        outputStream.close();
        socket.close();
    }


}
