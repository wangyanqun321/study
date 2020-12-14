package com.wyq.study.dubbo.provider.service;

import com.wyq.study.dubbo.facade.MyResponse;
import com.wyq.study.dubbo.facade.Response;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author 王艳群
 * @description MyAdvice
 * @date 2020/10/22
 */
@Component
@Aspect
public class MyAdvice {

    @Around(value="execution (* com.wyq.study.dubbo.provider.service.TestServiceImpl.*(..))")
    public Object afterReturningMethod(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method name:"+methodName);
        return new MyResponse("fsdaf", "fdsafasddsfdf");
    }

}
