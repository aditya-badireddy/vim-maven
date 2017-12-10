package com.cg.vim.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.cg.vim.configuration.JpaConfiguration;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.cg.vim"})
public class VIMApplication {

	public static void main(String[] args) {
		SpringApplication.run(VIMApplication.class, args);
	}
}
