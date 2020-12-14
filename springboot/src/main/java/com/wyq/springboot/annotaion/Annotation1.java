package com.wyq.springboot.annotaion;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Annotation2
public @interface Annotation1 {
}
