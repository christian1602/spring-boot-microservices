package com.christian.microservice.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // [OPCIONAL]: Anotacion para establecer que este microservicio sera un microservicio de eureka
public class MicroserviceStudentApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceStudentApplication.class, args);
    }
}
