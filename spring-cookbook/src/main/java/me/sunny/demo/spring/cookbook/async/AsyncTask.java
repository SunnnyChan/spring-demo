package me.sunny.demo.spring.cookbook.async;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * @author sunnny@gmail.com
 * 测试异步执行
 */

@Component
public class AsyncTask {

    /**
     * @param second sleep time
     */
    @Async
    public Future<String> doTask1(Integer second) {
        try {
            System.out.println("Async do task 1 start : " + System.currentTimeMillis() / 1000);
            TimeUnit.SECONDS.sleep(second);
            System.out.println("Async do task 1 end : " + System.currentTimeMillis() / 1000);
        } catch (InterruptedException e ) {
            System.out.println("InterruptedException occur");
        }
        return new AsyncResult<>("task 1 return");
    }

    /**
     * @param second sleep time
     */
    @Async
    public Future<String> doTask2(Integer second) {
        try {
            System.out.println("Async do task 2 start : " + System.currentTimeMillis() / 1000);
            TimeUnit.SECONDS.sleep(second);
            System.out.println("Async do task 2 end : " + System.currentTimeMillis() / 1000);
        } catch (InterruptedException e ) {
            System.out.println("InterruptedException occur");
        }
        return new AsyncResult<>("task 2 return");
    }

}
