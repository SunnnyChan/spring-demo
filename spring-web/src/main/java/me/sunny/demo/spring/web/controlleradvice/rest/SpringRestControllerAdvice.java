package me.sunny.demo.spring.web.controlleradvice.rest;

import java.util.HashMap;

import me.sunny.demo.spring.web.controlleradvice.exception.RrException;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author sunnnychan@gmail.com
 */
@RestControllerAdvice(basePackageClasses = AdviceRestController.class)
public class SpringRestControllerAdvice {
    /**
     * 全局数据预处理
     *
     * 应用到所有 @RequestMapping 注解方法，在其执行之前初始化数据绑定器
     * @param binder WebDataBinder
     */
    @InitBinder("b")
    public void initB(WebDataBinder binder) {
        System.out.println("binder.getFieldDefaultPrefix : " + binder.getFieldDefaultPrefix());
        binder.setFieldDefaultPrefix("b.");
        System.out.println("binder.getFieldMarkerPrefix : "+ binder.getFieldMarkerPrefix());
    }

    @InitBinder("a")
    public void initA(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("a.");
    }

    /**
     * 全局数据绑定
     *
     * 使用 @ModelAttribute 注解标记该方法的返回数据是一个全局数据，
     * 默认情况下，这个全局数据的 key 就是返回的变量名，value 就是方法返回值，
     * 当然开发者可以通过 @ModelAttribute 注解的 name 属性去重新指定 key。
     *
     * @param model Model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "harry");
    }

    /**
     * 全局异常处理
     *
     * @author honghh
     * @date  2019/4/1 0001 10:34
     * @param ex 异常
     * @return HashMap
     */
    @ExceptionHandler(RrException.class)
    public HashMap apiExceptionHandler(RrException ex) {
        System.out.println("ApiException 异常抛出：" + ex);
        HashMap<String, String> ret = new HashMap<>(20);
        ret.put("errorCode", Integer.toString(ex.getCode()));
        ret.put("errorMsg", ex.getMsg());
        return ret;
    }
}
