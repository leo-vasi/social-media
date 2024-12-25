package com.leo.socialmedia.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {

    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError() {

    }

    public StandardError(String error, String message, String path, Integer status, Long timestamp) {
        this.error = error;
        this.message = message;
        this.path = path;
        this.status = status;
        this.timestamp = timestamp;
    }



    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
