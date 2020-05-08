package me.sunny.demo.spring.cookbook;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.support.StandardServletEnvironment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class TestSpringEnv {

    @Autowired
    private Environment environment;

    @Test
    public void testGetSpringEnv(){
       System.out.println(JSON.toJSONString(environment.getActiveProfiles()));
       System.out.println(JSON.toJSONString(environment.getDefaultProfiles()));
    }
}
