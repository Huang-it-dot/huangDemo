package com.huang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@MapperScan("com.huang.Mapper")
public class JavaSpringLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringLearnApplication.class, args);
	}

}
