package me.sunny.demo.spring.boot.starter;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sunnnychan@gmail.com
 *
 * 这里不需要 @Service，因为已经通过DemoAutoConfiguration注入spring容器了。
 */

public class DemoService {

    @Autowired
    private DemoProperties demoProperties;

    public void print() {
        System.out.println(demoProperties.getName());
        System.out.println(demoProperties.getAge());
    }
}
