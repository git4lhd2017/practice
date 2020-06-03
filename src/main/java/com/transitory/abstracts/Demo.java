package com.transitory.abstracts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: basicDemo
 * @description: 运行创建类
 * @author: 无能狂怒
 * @create: 2020-02-22 16:28
 **/


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-test.xml")
public class Demo {




    /**
    * @Description:测试类，抽象类可以被创建，但是在创建时要完成抽象方法的重写，静态方法无法重写，无法实现，但可以直接调用
    * @Param: []
    * @return: void
    * @Author: 无能狂怒
    * @Date: 2020/2/22
    */
    @Test
    public  void test() {

        //创建抽象类的实例，但要重写它的抽象方法，重写时可以直接调用父类的默认方法
        AbstractDemo demo1 = new AbstractDemo() {
            @Override
            public String getDescription() {
                return "部分重写";
            }
        };



        System.out.println(demo1.getDescription());
        System.out.println(demo1.getDescription2());
        demo1.demo();
        Abstractimpl demo2 = new Abstractimpl();
        System.out.println(demo2.getDescription4sub());
        System.out.println(demo2.getDescription());
        demo2.demo();

        System.out.println("-----------------------------------------");

        System.out.println(demo1.a+";"+demo1.pojo);

        demo1.testMethod();

        System.out.println(demo1.a+";"+demo1.pojo);
    }







}
