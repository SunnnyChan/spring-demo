package me.sunny.demo.spring.cookbook.async;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

/**
 * @author sunnny@gmail.com
 */

@Component
public class SyncTask {

    public void doTask1() {
        try {
            System.out.println("do task 1 start : " + System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(1);
            System.out.println("do task 1 end : " + System.currentTimeMillis());
        } catch (InterruptedException e ) {
            System.out.println("InterruptedException occur");
        }

    }

    public void doTask2() {
        try {
            System.out.println("do task 2 start : " + System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(1);
            System.out.println("do task 2 end : " + System.currentTimeMillis());
        } catch (InterruptedException e ) {
            System.out.println("InterruptedException occur");
        }

    }

}
