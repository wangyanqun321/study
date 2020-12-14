package com.wyq.java.annotation;

import java.lang.annotation.*;

/**
 * @author 王艳群
 * @description Annotation1
 * @date 2020/10/2
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Inherited
public @interface Annotation1 {
}
