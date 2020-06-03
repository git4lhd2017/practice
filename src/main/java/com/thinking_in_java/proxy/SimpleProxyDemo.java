package com.thinking_in_java.proxy;

/**
 * @program: basicDemo
 * @description: 简单的代理
 * @author: 无能狂怒
 * @create: 2020-05-29 13:45
 **/
class SimpleProxy implements BasicClass {

    private BasicClass proxied;

    public SimpleProxy(BasicClass proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println(this.getClass().getSimpleName()+"do something!");
        proxied.doSomething();
    }

    @Override
    public void doSomething(String args) {
        System.out.println(this.getClass().getSimpleName()+"do something esle "+args);
        this.proxied.doSomething(args);
    }
}

public class SimpleProxyDemo{

    public void consumer(BasicClass bc){
        bc.doSomething();
        String things = "play Basketball!";
        bc.doSomething(things);
    }

    public static void main(String[] args) {
        SimpleProxyDemo demo = new SimpleProxyDemo();
        demo.consumer(new RealObject());
        demo.consumer(new SimpleProxy(new RealObject()));
    }
}
