package com.wyq.study.dubbo.facade;

import java.io.Serializable;

/**
 * @author 王艳群
 * @description MyResponse
 * @date 2020/10/22
 */
public class MyResponse implements Serializable {

    private String data;

    private String message;

    public MyResponse(String data, String message) {
        this.data = data;
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
