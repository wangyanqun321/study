package com.wyq.java.lang;

/**
 * @author 王艳群
 * @description ClassLoaderTest
 * @date 2020/7/25
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class aClass = ClassLoaderTest.class.getClassLoader().loadClass("com.wyq.java.lang.TestClassLoader");
        // System.out.println(aClass.isLocalClass());
        TestClassLoaderImpl classLoader = new TestClassLoaderImpl();
        classLoader.load("com.wyq.java.lang.TestClassLoader", true);
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
    }
}
