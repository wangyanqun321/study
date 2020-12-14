package com.wyq.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 王艳群
 * @description SelectorTest
 * @date 2020/10/6
 */
public class SelectorServer {

    private ServerSocketChannel serverSocketChannel;

    private Selector selector;

    public static void main(String[] args) throws IOException {

        new SelectorServer().start();

    }

    public void init() {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(8080));
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void start() throws IOException {
        init();
        System.out.println("服务器启动了...");
        while (true) {
            Set<SelectionKey> keys = selector.keys();
            System.out.println("keys.size: " + keys.size());
            while (selector.select() > 0) {
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();

                    iterator.remove();
                    if(selectionKey.isAcceptable()) {
                        ServerSocketChannel channel = (ServerSocketChannel)selectionKey.channel();
                        accept(channel);
                    }else if(selectionKey.isReadable()) {
                        read(selectionKey);
                    }else if(selectionKey.isWritable()) {
                        SocketChannel channel = (SocketChannel)selectionKey.channel();
                        write(channel);
                    }
                }
            }
        }
    }

    private void read(SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel)selectionKey.channel();
        channel.configureBlocking(false);
        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
        int num = 0;
        num = channel.read(byteBuffer);
        if(num > 0) {
            byteBuffer.flip();
            byte[] data = new byte[byteBuffer.limit()];
            byteBuffer.get(data);
            String result = new String(data, StandardCharsets.UTF_8);
            System.out.println(channel.socket().getPort() + ": " + result);
            byteBuffer.clear();
        }else {
            selectionKey.cancel(); // Some JDK implementations run into an infinite loop without this.
            System.out.println("客户端: "+ channel.getRemoteAddress() +" 已关闭!");
        }
    }

    private void write(SocketChannel client) throws IOException {
        String sendTxt = "Message from Server";
        ByteBuffer sendBuffer = ByteBuffer.allocate(9102);
        sendBuffer.put(sendTxt.getBytes());
        sendBuffer.flip();
        int code = 0;

        //如果sendBuffer内容一次没有写完，会在下一次事件中处理吗？
        while (client.write(sendBuffer) != 0){
        }
        //code=0，消息写完
        sendBuffer.clear();
        System.out.println("Send message to client ");
        //在读通知里面注册为写事件，所以这里还需要注册为读，否则不在接受客户端消息
        client.register(selector,SelectionKey.OP_READ);
    }

    private void accept(ServerSocketChannel channel) throws IOException {
        channel.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(8192);
        SocketChannel client = channel.accept();
        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_READ, buffer);
        System.out.println("=========================");
        System.out.println("接收到新客户端：" + client.getRemoteAddress());
        System.out.println("=========================");
    }

}
