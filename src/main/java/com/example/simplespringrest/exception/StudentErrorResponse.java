package com.example.simplespringrest.exception;

public class StudentErrorResponse{
    private String message;
    private Integer status;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(String message, Integer status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getstatus() {
        return status;
    }

    public void setstatus(Integer status) {
        this.status = status;
    }
}
