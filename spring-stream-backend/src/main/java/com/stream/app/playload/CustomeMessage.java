package com.stream.app.playload;

public class CustomeMessage {

    private String msg;
    private boolean success=false;


    public CustomeMessage(String msg, boolean success) {
        this.msg = msg;
        this.success = success;
    }

    public CustomeMessage() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
