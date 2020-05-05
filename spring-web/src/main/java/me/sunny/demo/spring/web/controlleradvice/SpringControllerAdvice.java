package me.sunny.demo.spring.web.controlleradvice;

import java.util.Arrays;
import java.util.HashMap;

import me.sunny.demo.spring.web.controlleradvice.exception.ScException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sunnnychan@gmail.com
 */
@ControllerAdvice(basePackageClasses = AdviceController.class)
public class SpringControllerAdvice {

    @ExceptionHandler(ScException.class)
    @ResponseBody
    public HashMap<String, String> runtimeException(RuntimeException ex) {
        Arrays.stream(ex.getStackTrace()).forEach(r -> System.out.println(r.toString()));
        HashMap<String, String> ret = new HashMap<>(20);
        ret.put("errorMsg", ex.getMessage());
        return ret;
    }
}
