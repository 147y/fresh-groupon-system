package com.fresh.freshgrouponsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.fresh.freshgrouponsystem.mapper")
@SpringBootApplication
public class FreshGrouponSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreshGrouponSystemApplication.class, args);
	}

}
