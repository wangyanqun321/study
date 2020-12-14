package com.wyq.study.flink.common;

/**
 * @author 王艳群
 * @description Result
 * @date 2020/9/14
 */
public class Response {
    private String success;

    private Weather result;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Weather getResult() {
        return result;
    }

    public void setResult(Weather result) {
        this.result = result;
    }
}
