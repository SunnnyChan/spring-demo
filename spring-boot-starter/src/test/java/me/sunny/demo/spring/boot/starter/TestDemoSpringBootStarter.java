package me.sunny.demo.spring.boot.starter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoAutoConfiguration.class})
public class TestDemoSpringBootStarter {

    @Autowired
    private DemoService demoService;

    @Test
    public void test(){
        demoService.print();
    }
}
