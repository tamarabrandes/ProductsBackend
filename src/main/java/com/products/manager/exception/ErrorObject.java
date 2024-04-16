package com.products.manager.exception;


import java.util.Date;

public class ErrorObject {
    private Integer statusCode;
    private String message;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    private Date timestamp;

    @Override
    public String toString() {
        return "ErrorObject{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
