package com.wyq.java.lang;

/**
 * @author 王艳群
 * @description TestClassLoaderImpl
 * @date 2020/7/25
 */
public class TestClassLoaderImpl extends ClassLoader {

    public void load(String name, boolean resolve) throws ClassNotFoundException {
        this.loadClass(name, resolve);
    }
}
