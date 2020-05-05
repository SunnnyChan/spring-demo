package me.sunny.demo.spring.event;

import org.springframework.context.ApplicationEvent;
/**
 * StudentAddEvent类 中需要实现自己的构造函数
 *
 * @author sunnnychan@gmail.com
 */
public class StudentAddEvent extends ApplicationEvent {

    private static final long serialVersionUID = 20L;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * @param source
     */
    public StudentAddEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
