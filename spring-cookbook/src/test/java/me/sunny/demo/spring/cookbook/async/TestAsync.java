package me.sunny.demo.spring.cookbook.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import me.sunny.demo.spring.cookbook.async.AsyncTask;
import me.sunny.demo.spring.cookbook.async.SyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAsync {

    @Autowired
    SyncTask syncTask;

    @Autowired
    AsyncTask asyncTask;

    @Test
    public void testSyncTask() {
        syncTask.doTask1();
        syncTask.doTask2();
    }

    /**
     * task 1 先完成
     * future1.get() 和 future2.get() 都阻塞
     */
    @Test
    public void testAsyncTask1() throws InterruptedException, ExecutionException {
        Future<String> future1 = asyncTask.doTask1(1);
        Future<String> future2 = asyncTask.doTask2(2);
        String result1 = future1.get();
        System.out.println(result1);
        String result2 = future2.get();
        System.out.println(result2);
    }

    /**
     * task 2 先完成
     * future1.get() 会阻塞，future2.get()不会阻塞，因为 task 2 执行快，
     * 在等待 task 1完成的时候，task 2已经执行完成。
     */
    @Test
    public void testAsyncTask2() throws InterruptedException, ExecutionException {
        Future<String> future1 = asyncTask.doTask1(2);
        Future<String> future2 = asyncTask.doTask2(1);
        String result1 = future1.get();
        System.out.println(result1);
        String result2 = future2.get();
        System.out.println(result2);
    }


}
