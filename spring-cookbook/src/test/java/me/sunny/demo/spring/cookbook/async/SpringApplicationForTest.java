package me.sunny.demo.spring.cookbook.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringApplicationForTest {

    public static void main(String[] args){
        SpringApplication.run(SpringApplicationForTest.class);
    }

}
