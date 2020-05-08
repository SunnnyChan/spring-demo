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
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.support.StandardServletEnvironment;

/**
 * 测试获取Spring Web 的环境变量、配置信息
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:spring.xml"})
public class TestSpringWebEnv {

    @Autowired
    private Environment environment;

    @Test
    public void testGetSpringWebEnv(){
        StandardServletEnvironment standardServletEnvironment = (StandardServletEnvironment) environment;
        Map<String, Map<String, String>> map = new HashMap<>(8);
        Iterator<PropertySource<?>> iterator = standardServletEnvironment.getPropertySources().iterator();
        while (iterator.hasNext()) {
            PropertySource<?> source = iterator.next();
            Map<String, String> m = new HashMap<>(128);
            String name = source.getName();
            Object o = source.getSource();
            if (o instanceof Map) {
                for (Map.Entry<String, Object> entry : ((Map<String, Object>) o).entrySet()) {
                    String key = entry.getKey();
                    m.put(key, standardServletEnvironment.getProperty(key));
                }
            }
            map.put(name, m);
        }
        System.out.println("Spring Web Env : " + JSON.toJSONString(map));
    }

}
