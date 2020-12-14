package com.wyq.java.autoclose;

/**
 * @author 王艳群
 * @description Resource
 * @date 2020/8/30
 */
public class Resource implements AutoCloseable {

    public void doWork() {
        System.out.println("working ....");
    }

    @Override
    public void close() throws Exception {
        System.out.println("自动关闭");
    }

    public static void main(String[] args) {
        try(Resource resource = new Resource()){
            resource.doWork();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
