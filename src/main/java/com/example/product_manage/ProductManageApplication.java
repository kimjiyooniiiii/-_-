package com.example.product_manage;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class ProductManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManageApplication.class, args);
	}

	@Bean
	@Profile("prod")
	public ApplicationRunner runner(DataSource dataSource){		// 어플리케이션 시작과 함께 커넥션 풀을 생성해 클라이언트의 요청 지연을 방지
		return args -> {
			Connection connection = dataSource.getConnection();
		};
	}

}
