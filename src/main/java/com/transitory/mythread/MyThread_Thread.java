package com.transitory.mythread;

/**
 * @program: basicDemo
 * @description: 继承thread的线程
 * @author: 无能狂怒
 * @create: 2020-03-07 17:30
 **/
public class MyThread_Thread extends Thread {

    private int totalticket = 100;

    @Override
    public void run() {
        while (totalticket > 0){
            totalticket--;
            System.out.println("现在还有"+totalticket+"张票,"+Thread.currentThread().getName()+"一共卖了"+(100-totalticket)+"张票!");
        }
    }
}
