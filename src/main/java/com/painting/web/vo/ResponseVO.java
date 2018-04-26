package com.painting.web.vo;

/**
 * 返回数据
 * @param <T>
 */
public class ResponseVO<T>{

    private Integer code;
    private String errMsg;
    private T data;

    public ResponseVO() {
    }

    public ResponseVO(Integer code) {
        this.code = code;
    }

    public ResponseVO(Integer code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
