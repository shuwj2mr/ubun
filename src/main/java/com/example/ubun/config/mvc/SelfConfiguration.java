package com.example.ubun.config.mvc;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//WebMvcConfigurationSupport和WebMvcConfigurer
@Configuration
public class SelfConfiguration implements WebMvcConfigurer {

    //
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController ("/").setViewName ("forward:/upload.html");
        registry.setOrder (Ordered.HIGHEST_PRECEDENCE);
    }

    //添加资源映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler ("/static/**").addResourceLocations ("classpath:static/");
    }

}
