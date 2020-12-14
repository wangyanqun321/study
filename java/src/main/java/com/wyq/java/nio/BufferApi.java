package com.wyq.java.nio;

import sun.nio.cs.ext.GBK;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author 王艳群
 * @description BufferApi
 * @date 2020/10/6
 */
public class BufferApi {

    public static void main(String[] args) throws Exception {
        testFileReader();
        //testBuffer();
    }

    public static void testFileReader() throws Exception {
        FileInputStream in = new FileInputStream(
            new File("F:\\document\\bigdata\\[发布版]若泽数据-CDH5.16.1+CDH6.3.1企业离线部署" +
                "\\[发布版]若泽数据-CDH5.16.1 企业离线部署--文档\\笔记.txt"));
        FileChannel channel = in.getChannel();
        ByteBuffer bf = ByteBuffer.allocate(1024);
        System.out.println("限制是：" + bf.limit() + ",容量是：" + bf.capacity() + " ,位置是：" + bf.position());
        int length = -1;
        while ((length = channel.read(bf)) != -1) {
            bf.flip();
            //bf.clear();
            byte[] bytes = bf.array();
            System.out.println("限制是：" + bf.limit() + ",容量是：" + bf.capacity() + " ,位置是：" + bf.position());
            System.out.println(new String(bytes, 0 , length, new GBK()));
            //bf.clear();
            //Thread.sleep(1000);
        }
        bf.clear();
        channel.close();
    }

    public static void testBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println("限制是：" + byteBuffer.limit() + ",容量是：" + byteBuffer.capacity() + " ,位置是：" + byteBuffer.position());
        byteBuffer.limit(5);
        byteBuffer.put( "你".getBytes());
        byte b = byteBuffer.get();
        byteBuffer.get();
        byteBuffer.get();
        System.out.println(b);

        System.out.println("限制是：" + byteBuffer.limit() + ",容量是：" + byteBuffer.capacity() + " ,位置是：" + byteBuffer.position());
    }

}
