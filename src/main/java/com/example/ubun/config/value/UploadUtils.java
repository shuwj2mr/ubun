package com.example.ubun.config.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:config/common.properties",encoding = "utf-8")    //注入不了
public class UploadUtils {
    @Value("${upload.url}")
    private String uploadurl;

    public String getUploadurl() {
        return uploadurl;
    }

    public void setUploadurl(String uploadurl) {
        this.uploadurl = uploadurl;
    }
}
