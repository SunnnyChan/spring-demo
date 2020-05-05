package me.sunny.demo.spring.event;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ApplicationContext 在运行期会自动检测到所有实现了 ApplicationListener 的 bean 对象，并将其作为事件接收对象。
 * 当 ApplicationContext 的 publishEvent 方法被触发时，每个实现了 ApplicationListener 接口的bean 都会收到 ApplicationEvent 对象，
 * 每个 ApplicationListener 可根据事件类型只接收处理自己感兴趣的事件，比如上面的 StudentAddListener 只接收 StudentAddEvent 事件。
 */
public class TestEvent {

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(StudentAddEventConfig.class);
        StudentAddBean studentBean = (StudentAddBean) context.getBean("studentAddBean");
        studentBean.addStudent("张三");
        studentBean.addStudent("李四");
    }

}
