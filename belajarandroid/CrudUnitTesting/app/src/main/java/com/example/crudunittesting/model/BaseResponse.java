package com.example.crudunittesting.model;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("status")
    String status;
    @SerializedName("code")
    Integer code;

    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
