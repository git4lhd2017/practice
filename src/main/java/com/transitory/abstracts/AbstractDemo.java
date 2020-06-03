package com.transitory.abstracts;

import com.transitory.pojo.TestPojo;

/**
 * @program: basicDemo
 * @description: 抽象类的测试demo
 * @author: 无能狂怒
 * @create: 2020-02-22 16:24
 **/
public abstract class AbstractDemo {
    
    final static String description = "this is abstract class！";
    final static String description2 = "this is abstract class！2";

    public int a = 5;
    public TestPojo pojo = null;


    public void testMethod(){
    a = a + 6; //报错，字段前默认加final修饰
    pojo = new TestPojo("小明",15,"男");
    }


    /** 
    * @Description: getter 
    * @Param: []
    * @return: java.lang.String 
    * @Author: 无能狂怒 
    * @Date: 2020/2/22 
    */
    public String getDescription(){
        return description;
    }
    public String getDescription2(){
        return description2;
    }

    public static void demo(){
        System.out.println("this is abstract class demo method!");
    }
    
}
