package com.example.ubun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class UbunApplication {
	/**
	 * //https://blog.csdn.net/qq_38455201/article/details/81990564 //https://www.cnblogs.com/lfjjava/p/6096884.html
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(UbunApplication.class, args);
	}

}
