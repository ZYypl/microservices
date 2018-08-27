package com.zy.micro.common;

import com.alibaba.fastjson.JSON;

/**
 * 封装返回前台的结果
 */
public class ApiResult {

    private Boolean result;
    private Object data;
    private String message;

    public ApiResult() {
    }

    public ApiResult(Boolean result) {
        this.result = result;
    }

    public ApiResult(boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    public ApiResult(Boolean result, Object data, String message) {
        this.result = result;
        this.data = data;
        this.message = message;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
