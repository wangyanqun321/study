package com.wyq.socket;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 王艳群
 * @description SocketClient
 * @date 2020/6/3
 */

public class SocketClient {
    public static void main(String args[]) throws Exception {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 9000;
        // 与服务端建立连接
        Socket socket = new Socket(host, port);
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        byte[] b = new byte[1024];
        while(socket.getInputStream().read(b) > 0) {
            System.out.println(new String(b));
        }
        outputStream.close();
        socket.close();
    }
}
