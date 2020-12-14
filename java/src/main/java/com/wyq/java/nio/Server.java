package com.wyq.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Collection;
import java.util.LinkedList;

/**
 * @author 王艳群
 * @description Server
 * @date 2020/10/5
 */
public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {

        Collection<SocketChannel> socketChannels = new LinkedList<>();

        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress("localhost", 8080));
        ss.configureBlocking(false);
        while (true) {
            //Thread.sleep(1000);
            SocketChannel client = ss.accept();
            if(client == null) {
                //System.out.println("没有接收到客户端信息");
            }else {
                client.configureBlocking(false);
                int port = client.socket().getPort();
                System.out.println("port:" + port);
                socketChannels.add(client);
            }

            ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
            //System.out.println(socketChannels.size());
            for(SocketChannel socketChannel : socketChannels){
                int num = socketChannel.read(byteBuffer);
                if(num > 0) {
                    byteBuffer.flip();
                    byte[] data = new byte[byteBuffer.limit()];
                    byteBuffer.get(data);
                    String result = new String(data);
                    System.out.println(socketChannel.socket().getPort() + ": " + result);
                    byteBuffer.clear();
                }
            }
        }
    }

}
