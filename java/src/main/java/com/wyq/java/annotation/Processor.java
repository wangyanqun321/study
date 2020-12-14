package com.wyq.java.annotation;

import java.lang.annotation.Annotation;

/**
 * @author 王艳群
 * @description Processor
 * @date 2020/10/2
 */
@Annotation2
public class Processor {

    public static void main(String[] args) {
       Class clazz = Processor.class;
        Annotation annotation = clazz.getAnnotation(Annotation2.class);
        Class<? extends Annotation> aClass = annotation.annotationType();
        for(Annotation clz : aClass.getAnnotations()) {
             System.out.println(clz.annotationType());
        }
    }
}
