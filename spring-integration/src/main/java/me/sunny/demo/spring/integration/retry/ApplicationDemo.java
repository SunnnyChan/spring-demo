package me.sunny.demo.spring.integration.retry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

@Configuration
@EnableRetry
public class ApplicationDemo {

  @Bean
  public ServiceDemo service() {
    return new ServiceDemo();
  }
}
