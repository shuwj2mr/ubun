package com.example.ubun.config.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//springboot 指定任意目录文件,非常强大
@Component
//@ConfigurationProperties(prefix = "")   //定位前缀
@PropertySource(value = "classpath:config/common.properties"
        , ignoreResourceNotFound = true
        , encoding = "utf-8")
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
