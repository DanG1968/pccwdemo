package com.pccw.pccwdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.pccw.pccwdemo")
@EnableJpaRepositories(basePackages = "com.pccw.pccwdemo.repository")
public class PccwdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PccwdemoApplication.class, args);
    }

}
