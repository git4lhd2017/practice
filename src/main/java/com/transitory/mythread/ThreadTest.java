package com.transitory.mythread;

import com.transitory.pojo.TestPojo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.*;

/**
 * @program: basicDemo
 * @description: 线程的运行测试类
 * @author: 无能狂怒
 * @create: 2020-03-07 17:50
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-test.xml")
public class ThreadTest {

    @Test
    public void thread_thread(){
        MyThread_Thread t = new MyThread_Thread();
        t.setName("一号售票员");
        t.start();

    }

    @Test
    public void  thread_runnable(){
        Thread t = new Thread(new MyThread_Runnable(),"一号售票员");
        t.start();
    }

    @Test
    public void  thread_callable() throws ExecutionException, InterruptedException {

        FutureTask<String> f = new FutureTask<>(new MyThread_Callable());
            Thread t = new Thread(f,"一号售票员");
            t.start();
        String s = f.get();
        System.out.println(s);
    }



    @Test
    public  void  thread_convert() throws ExecutionException, InterruptedException {
        Callable<String> c = new MyThread_Callable();
        Runnable r = new MyThread_Runnable();

        //将runnable转换成callable，虽然没搞清楚返回值是怎么用的，但是实现了调用
        Callable<Object> r_c = Executors.callable(r);

        FutureTask<Object> f = new FutureTask(r_c);//这里面的参数可以用runnable也可以用callable

        Thread t = new Thread(f,"r_c");

        t.start();

        Object o = f.get();
        System.out.println(o);//null


    }


    @Test
    public void thread_pool(){
        ThreadFactory threadFactory = r -> {
           return new Thread(new MyThread_Runnable(),"售票员");
        };
        ExecutorService executorService = Executors.newCachedThreadPool(threadFactory);
        executorService.execute(this::thread_pool);
        executorService.execute(this::thread_pool);
    }

}
