package me.sunny.demo.spring.integration.retry.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RetryTemplateDemo.class)
public class RecoveryCallbackTest {
  @Autowired
  RetryTemplate retryTemplate;

  @Test
  public void test() {
    Boolean execute = retryTemplate.execute(ctx -> testMethod("arg-1", 12), ctx -> callBack("arg-1", 12));
    System.out.println("result : " + execute);
  }

  private Boolean testMethod(String arg1, Integer arg2) throws RuntimeException {
    System.out.println("调用 testMethod 方法：arg1:" + arg1 + ",arg2:" + arg2);
    throw new RuntimeException("出错啦！");
  }

  private Boolean callBack(String arg1, Integer arg2) throws RuntimeException {
    System.out.println("调用 callBack 方法：arg1:" + arg1 + ",arg2:" + arg2);
    return false;
  }
}
