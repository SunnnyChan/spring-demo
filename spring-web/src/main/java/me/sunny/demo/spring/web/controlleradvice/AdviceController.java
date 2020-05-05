package me.sunny.demo.spring.web.controlleradvice;

import java.util.HashMap;
import java.util.Objects;

import me.sunny.demo.spring.web.controlleradvice.exception.ScException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sunnnychan@gmail.com
 */
@Controller
public class AdviceController {

    /**
     *  测试连接：
     *  http://127.0.0.1:9090/detail?id=
     *  http://127.0.0.1:9090/detail?id=9527
     */
    @RequestMapping(value = "/detail", method= RequestMethod.GET)
    @ResponseBody()
    public HashMap detail(@RequestParam("id") Integer id) {
        if (Objects.isNull(id)) {
            // Spring 框架会打印 error错误，一般不直接把异常抛给框架处理
            throw new ScException("user detail exception.");
        }
        HashMap<String, String> user = new HashMap<>();
        user.put("name", "sunny");
        user.put("id", id.toString());

        return user;
    }

}
