package me.sunny.demo.spring.web.controlleradvice.rest;

import java.util.HashMap;
import java.util.Objects;

import com.alibaba.fastjson.JSON;

import me.sunny.demo.spring.web.controlleradvice.exception.RrException;
import me.sunny.demo.spring.web.controlleradvice.miscs.Author;
import me.sunny.demo.spring.web.controlleradvice.miscs.Book;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunnnychan@gmail.com
 */
@RestController
public class AdviceRestController {

    /**
     *  测试连接：
     *  http://127.0.0.1:9090/myInfo?id=
     *  http://127.0.0.1:9090/myInfo?id=9527
     */
    @GetMapping("/myInfo")
    public String myInfo(@RequestParam("id") Integer id, Model model) {
        if (Objects.isNull(id)) {
            throw new RrException("id 不能为空！", 110);
        }
        HashMap<String, String> user = new HashMap<>(20);
        user.put("name", "sunny");
        user.put("id", id.toString());
        user.put("author", model.asMap().get("author").toString());
        return JSON.toJSONString(user);
    }

    /**
     * 测试连接：http://127.0.0.1:9090/book?b.name=sunny&b.price=100&a.name=jack&a.age=90
     *
     * 全局数据预处理
     *
     */
    @GetMapping("/book")
    public HashMap addBook(@ModelAttribute("b") Book book, @ModelAttribute("a") Author author) {
        HashMap<String, Object> ret = new HashMap<>(10);
        ret.put("book", book);
        ret.put("author", author);
        return ret;
    }
}
