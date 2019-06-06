package com.example.ubun.config.common;

import java.util.HashMap;
import java.util.Map;

public class ResponseWrapper {
    private int status;
    private Map<String, Object> dataWrapper = new HashMap ();
    private String msg;
    private boolean success;
    private String sourceUrl;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, Object> getDataWrapper() {
        return dataWrapper;
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

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public void addAttribute(String key, Object val) {
        this.dataWrapper.put(key, val);
    }

    public void removeAttribute(String key) {
        this.dataWrapper.remove(key);
    }

}
