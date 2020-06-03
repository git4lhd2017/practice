package com.transitory.classtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: basicDemo
 * @description: test
 * @author: 无能狂怒
 * @create: 2020-03-13 15:06
 **/

public class OneClass {

    public void test(){
        System.out.println("one!");
    }

    public void testArgs(String test){
        System.out.println("One:"+test);
    }


    public Integer testArith(int i){
        return 10 * i;
    }

}


class TwoClass  extends   OneClass {

//    protected void test(){ } 继承时权限不能降低
    public void test(){
        System.out.println("Two");
    }

//    public String testArgs(String test){return test;} 返回值类型不同，方法声明相同，报错，运行不过

//    public Long testArith(int i){return (long)20*i;} 不能通过编译，因为重载跟返回值无关，不过如果子类返回值为父类返回值的子类则可以运行


    public Integer testArith(long l){
        return (int) l * 20;
    }

    public static void main(String[] args) {
        OneClass one = new OneClass();
        TwoClass two = new TwoClass();

        one.test();
        one.testArgs("测试");
        two.test();
        two.testArgs("第二个测试");

        System.out.println(one.testArith(5));
        System.out.println(two.testArith(5));
        System.out.println(two.testArith((long)5));

    }


}




