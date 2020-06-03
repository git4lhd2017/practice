package com.thinking_in_java.proxy;

/**
 * @program: basicDemo
 * @description: 一个基本类接口用来代理
 * @author: 无能狂怒
 * @create: 2020-05-29 13:39
 **/
public interface BasicClass {


    void doSomething();

    void doSomething(String args);



}
class RealObject implements BasicClass{

    @Override
    public void doSomething() {
        System.out.println(this.getClass().getSimpleName()+"做了一些什么！");
    }

    @Override
    public void doSomething(String args) {
        System.out.println(this.getClass().getSimpleName() +"do something else"+args);
    }
}