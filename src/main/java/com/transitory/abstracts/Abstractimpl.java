package com.transitory.abstracts;

/**
 * @program: basicDemo
 * @description: 实现类测试
 * @author: 无能狂怒
 * @create: 2020-02-22 16:26
 **/
public class Abstractimpl extends AbstractDemo {


    @Override
    public String getDescription() {
        return super.getDescription();
    }

    public static void demo(){
//        super.demo(); //cannot be referenced from a static context;
        System.out.println("this is the sub class demo method");
    }

    final static String description = "this is inherit class!";

    public String getDescription4sub(){
        return this.description;
    }

}
