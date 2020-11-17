package me.sunny.demo.spring.integration.retry.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.policy.SoftReferenceMapRetryContextCache;
import org.springframework.retry.support.RetryTemplate;

public class RetryTemplateDemo {

  @Bean(name = "retryTemplate")
  public RetryTemplate getRetryTemplate() {
    RetryTemplate template = new RetryTemplate();

    FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
    //设置2s重试一次
    backOffPolicy.setBackOffPeriod(2000);
    template.setBackOffPolicy(backOffPolicy);

    SoftReferenceMapRetryContextCache contextCache = new SoftReferenceMapRetryContextCache();
    template.setRetryContextCache(contextCache);

    SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
    template.setRetryPolicy(retryPolicy);

    template.setThrowLastExceptionOnExhausted(true);
    return template;
  }
}
