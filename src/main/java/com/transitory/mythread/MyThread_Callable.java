package com.transitory.mythread;

import java.util.concurrent.Callable;

/**
 * @program: basicDemo
 * @description: 实现了Callable接口的线程
 * @author: 无能狂怒
 * @create: 2020-03-07 17:46
 **/
public class MyThread_Callable implements Callable<String> {

    private int totalticket = 100;

    @Override
    public String call() throws Exception {
        totalticket--;
        String result = "现在还有"+totalticket+"张票，"+Thread.currentThread().getName()+"总共卖了"+(100 - totalticket)+"张票";
        return result;
    }
}
