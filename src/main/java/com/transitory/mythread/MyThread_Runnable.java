package com.transitory.mythread;

/**
 * @program: basicDemo
 * @description: 实现runnable的接口的线程
 * @author: 无能狂怒
 * @create: 2020-03-07 17:44
 **/
public class MyThread_Runnable implements Runnable {

    private int totalticket = 100;

    @Override
    public void run() {
        while (totalticket > 0){
            totalticket--;
            System.out.println("现在还有"+totalticket+"张票,"+Thread.currentThread().getName()+"一共卖了"+(100-totalticket)+"张票!");
        }
    }

}
