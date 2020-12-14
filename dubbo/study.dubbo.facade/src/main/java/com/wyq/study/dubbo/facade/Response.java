package com.wyq.study.dubbo.facade;

import java.io.Serializable;

/**
 * @author 王艳群
 * @description Response
 * @date 2020/10/22
 */
public class Response implements Serializable {

    private Object data;

    private String message;

    public Response(Object data, String message) {
        this.data = data;
        this.message = message;
    }
}
