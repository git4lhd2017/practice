package com.transitory.mythread;

import org.springframework.util.CustomizableThreadCreator;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @program: basicDemo
 * @description: thread应用
 * @author: 无能狂怒
 * @create: 2020-03-07 18:15
 **/
public class Mythread {

    //假如我有100张票
    private int totalticket = 100;


    //我想开设窗后售票，这时需要到了线程的创建
    //1,runnable
    class RunnableThread implements Runnable{
        @Override
        public void run() {
            //锁住票
            synchronized ((Object)totalticket){
            if (totalticket > 0){
                totalticket--;
                System.out.println("现在还有"+totalticket+"张票,"+Thread.currentThread().getName()+"一共卖了"+(100-totalticket)+"张票!");
            }else{
                System.out.println(Thread.currentThread().getName()+"的票售光了！");
            }
            }
        }

    }

    class CallableThread implements Callable<String> {

        @Override
        public String call() throws Exception {
            if (totalticket > 0){
                totalticket--;
                return ("现在还有"+totalticket+"张票,"+Thread.currentThread().getName()+"一共卖了"+(100-totalticket)+"张票!");
            }else{
                return (Thread.currentThread().getName()+"的票售光了！");
            }
        }
    }


    public int getTotalticket(){
        return totalticket;
    }


    //假设一个进票的渠道
    public String add(int addnum){
        if(addnum >= 0){
            this.totalticket += addnum;
            return "现在我的总票数为:"+totalticket;
        }else{
            return "请查看你的进票数";
        }
    }


    @Override
    public String toString() {
        return "我还有"+totalticket+"张票";
    }


    public static void main(String[] args) {
        Mythread m = new Mythread();
        ThreadFactory f = r -> {return new Thread(m.new RunnableThread(),"runnable售票员");};
        ExecutorService exe = Executors.newCachedThreadPool(f);
        for (int i =0 ;i<=102;i++){
        exe.execute(f.newThread(m.new RunnableThread()));
            System.out.println("第"+i+"次");
        }

    }


}
