package me.sunny.demo.spring.integration.retry.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ServiceRetryDemo.class})
public class RetryAnnotationBasedTest {

  @Autowired
  private ServiceRetryDemo serviceRetryDemo;

  @Test
  public void test() {
    serviceRetryDemo.execute();
  }
}
