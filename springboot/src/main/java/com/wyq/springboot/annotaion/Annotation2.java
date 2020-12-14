package com.wyq.springboot.annotaion;

import java.lang.annotation.*;

/**
 * @author 王艳群
 * @description Annotation2
 * @date 2020/10/2
 */


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Annotation2 {
}
