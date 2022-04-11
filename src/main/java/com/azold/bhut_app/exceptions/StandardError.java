package com.azold.bhut_app.exceptions;

public class StandardError{
    private String msg;
    private String data_hora;
    private Integer status;

    public StandardError() {
    }

    public StandardError(String msg, String data_hora, Integer status) {
        this.msg = msg;
        this.data_hora = data_hora;
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
