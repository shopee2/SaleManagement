package com.shopee2.Sale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan("com.shopee2")
public class SaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaleApplication.class, args);
	}

}
