package com.wyq.java.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author 王艳群
 * @description ChannelTest
 * @date 2020/7/8
 */
public class ChannelTest {

    @Test
    public void testGetChannel() {
        try(FileChannel inChannel = new FileInputStream("F:\\wordcount_result.csv").getChannel();
            FileChannel outChannel = new FileOutputStream("F:\\wordcount_result_2.csv").getChannel()) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (inChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                outChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOpen() {
        try(FileChannel inChannel = FileChannel.open(Paths.get("F:\\wordcount_result.csv"),
            StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("F:\\wordcount_result_2.csv"),
                StandardOpenOption.WRITE)) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (inChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                outChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOpen2() {

    }

}
