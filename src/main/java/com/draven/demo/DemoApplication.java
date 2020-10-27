package com.draven.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.draven.demo.dao")
@SpringBootApplication
public class DemoApplication{// extends SpringBootServletInitializer

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        // 注意这里要指向原先用main方法执行的Application启动类
//        return builder.sources(DemoApplication.class);
//    }
}
