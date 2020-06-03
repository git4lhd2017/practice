package com.transitory.container;

import com.transitory.pojo.TestPojo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: basicDemo
 * @description: list集合的测试类
 * @author: 无能狂怒
 * @create: 2020-02-22 18:31
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-test.xml")
public class ListContainer {


    /** 
    * @Description: 遍历操作
    * @Param: [] 
    * @return: void 
    * @Author: 无能狂怒 
    * @Date: 2020/2/22 
    */
    @Test
    public void ergodic(){
        List<TestPojo> list1 = new ArrayList<>();
        list1.add(new TestPojo("小二",14,"男"));
        list1.add(new TestPojo("小一",15,"男"));
        list1.add(new TestPojo("小四",12,"男"));
        list1.add(new TestPojo("小三",13,"男"));

        //传统迭代糖
        for (TestPojo testPojo : list1) {
            System.out.println(testPojo);
        }

        System.out.println("-----------------------------分割线--------------------------------");

        //利用forEach语法糖
        list1.forEach(testPojo -> System.out.println(testPojo));


        System.out.println("-----------------------------分割线--------------------------------");

        //用list的sort函数可进行自定义对象排序，首先要实现comparator接口并重写compare方法进行比较，详请看源码
        list1.sort((TestPojo o1,TestPojo o2) -> {
            if(o1.getAge()<o2.getAge())
            {return 1;} else{return -1;}
        });

        list1.forEach(pojo -> System.out.println(pojo));

        System.out.println("-----------------------------分割线--------------------------------");



        list1.sort((TestPojo o1,TestPojo o2) -> o1.getAge() - o2.getAge());


        list1.forEach(testPojo -> System.out.println(testPojo));

    }


    @Override
    public String toString() {
        return "this is "+this.getClass();
    }
}
