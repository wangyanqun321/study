package com.wyq.springboot.annotaion;

import org.springframework.core.annotation.MergedAnnotations;

/**
 * @author 王艳群
 * @description Processor
 * @date 2020/10/2
 */
@Annotation1
public class Processor {
    public static void main(String[] args) {
        boolean present = MergedAnnotations.from(Processor.class, MergedAnnotations.SearchStrategy.DIRECT).isPresent(Annotation2.class);
        System.out.println(present);
    }
}
