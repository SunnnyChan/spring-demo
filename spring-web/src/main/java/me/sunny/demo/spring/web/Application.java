package me.sunny.demo.spring.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sunnnychan@gmail.com
 */
@SpringBootApplication(scanBasePackages = {"me.sunny.demo.spring.web"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
