package com.bawei.sqw_week2.bean;

/**
 * Created by 小哥 on 2018/11/9.
 */

public class LoginResult {
    private boolean isSuccess;
    private String msg;

    public LoginResult() {
    }

    public LoginResult(boolean isSuccess, String msg) {
        this.isSuccess = isSuccess;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

