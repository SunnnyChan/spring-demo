package me.sunny.demo.spring.bean;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class TestBeanLifecycle {

    @Resource
    private ApplicationContext context;

    @Test
    public void test() {
        System.out.println("Context Application Name : " + context.getId());
    }
}
