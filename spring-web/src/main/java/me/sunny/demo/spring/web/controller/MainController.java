package me.sunny.demo.spring.web.controller;

import java.util.HashMap;

import com.alibaba.fastjson.JSON;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunnnychan@gmail.com
 */
@RestController
public class MainController {

    /**
     * http://127.0.0.1:9090/hello
     */
    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public String get() {
        HashMap<Integer, String> response = new HashMap<Integer, String>();
        response.put(1, "Hello World, RequestMapping.");
        return JSON.toJSONString(response);
    }

    @GetMapping("/hello2")
    public String get2() {
        HashMap<Integer, String> response = new HashMap<Integer, String>();
        response.put(1, "Hello World, GetMapping.");
        return JSON.toJSONString(response);
    }
}
