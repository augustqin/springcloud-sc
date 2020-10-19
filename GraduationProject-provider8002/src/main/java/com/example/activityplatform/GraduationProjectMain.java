package com.example.activityplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@MapperScan("com.example.activityplatform.dao")
@SpringBootApplication
@EnableEurekaClient
public class GraduationProjectMain {

    public static void main(String[] args) {
        SpringApplication.run(GraduationProjectMain.class, args);
    }

}
