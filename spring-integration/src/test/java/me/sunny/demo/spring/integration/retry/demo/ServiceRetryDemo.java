package me.sunny.demo.spring.integration.retry.demo;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@EnableRetry
public class ServiceRetryDemo {

  @Retryable(value = {Exception.class, RuntimeException.class}, maxAttempts = 3, backoff = @Backoff(delay = 2000L, multiplier = 2))
  public void execute() {
    System.out.println("调用 execute 方法");
    throw new RuntimeException("出错啦！");
  }

  @Recover
  public void recover(Throwable throwable) {
    System.out.println("调用 recover 方法");
  }
}
