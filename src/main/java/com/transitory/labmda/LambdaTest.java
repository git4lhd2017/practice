package com.transitory.labmda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: basicDemo
 * @description: lambda测试类
 * @author: 无能狂怒
 * @create: 2020-02-22 17:49
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-test.xml")
public class LambdaTest {


    //使用lambda表达式实现interface的factorial方法
    IsFunctionInterface lambda1 = (int a, int b) -> {return  a<<b ;};
    NotIsFunctionInterface lambda2 = (int a,int b) -> {return a << b ;};

    @Test
    public void test1(){
        System.out.println(lambda1.factorial(3,2));
        System.out.println(lambda2.factorial(3,2));
        System.out.println(lambda2.factorial2(3));
    }


}
