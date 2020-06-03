package com.transitory.arithmetic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: basicDemo
 * @description: 运算测试类
 * @author: 无能狂怒
 * @create: 2020-03-04 16:24
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-test.xml")
public class ArithTest {

    @Test
    public void test1(){
        int a =  ~ 978;
        System.out.println(a);
    }


}
