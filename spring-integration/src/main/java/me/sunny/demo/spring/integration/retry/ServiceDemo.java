package me.sunny.demo.spring.integration.retry;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class ServiceDemo {
  @Retryable(RemoteAccessException.class)
  public void service() {
    // ... do something
  }
  @Recover
  public void recover(RemoteAccessException e) {
    // ... panic
  }
}
