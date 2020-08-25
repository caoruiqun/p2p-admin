package com.caoruiqun.admin.common.rto;

/**
 * @program: 10-p2p-admin
 * @description:
 * @author: CaoRuiqun
 * @create: 2020-01-05 19:54
 **/
public class ReturnObject {
    private int errorCode;
    private String errorMessage;
    private Object data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
