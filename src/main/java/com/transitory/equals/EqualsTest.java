package com.transitory.equals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: basicDemo
 * @description: ==和equals的学习测试类
 * @author: 无能狂怒
 * @create: 2020-03-03 18:44
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-test.xml")
public class EqualsTest {


    @Test
    public void test_Integer(){


        Integer x = 128;
        Integer y = 128;
        System.out.println(x==y);//false
        System.out.println(x.equals(y));//true

        //Integer.Max_cache
        Integer a = 127;
        Integer b = 127;
        System.out.println(a==b);

        //Integer.Min_cache
        Integer q = -128;
        Integer p = -128;
        System.out.println(q==p);

        //int.max_value
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

    }

    /**
    * @Description: byte的缓存测试
    * @Param: []
    * @return: void
    * @Author: 无能狂怒
    * @Date: 2020/3/3
    */
    @Test
    public void test_Byte(){
        Byte a = 127;
        Byte b = 127;

        System.out.println(a == b);//false

        byte x = 127;
        byte y = 1;


//        x= (byte) x + y;报错，运算优先级问题
        x += y;
        //x= x + y; 报错，短数据类型转换问题
//        a += b;报错，包装类不能使用这种方法

    }


    @Test
    public void test_Short(){

        Short a = 127;
        Short b = 127;

        System.out.println(a==b);

    }

    @Test
    public void test_Float(){
        Float a = 1f;
        Float b = 1f;

        System.out.println(a==b);
    }

    @Test
    public void test_Double(){
        Double a = 1.2;
        Double b = 1.2;


        System.out.println(a == b);

    }


    @Test
    public void test_Character(){
        Character x = 127;
        Character y = 127;

        System.out.println(x == y);
        System.out.println(x+";"+y);
    }

    @Test
    public void test_Long(){
        Long a = new Long(127);
        Long b = new Long(127);

        System.out.println(a == b);

        Long x = Long.valueOf(127);
        Long y = Long.valueOf(127);
        System.out.println(x == y);
    }

    @Test
    public void test_boolean(){
        Boolean a = new Boolean("true");
        Boolean b = new Boolean("true");

        //new之后为false
        System.out.println(a==b);//false
    }



    @Test
    public void test_String(){

        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        System.out.println(a == b);
        System.out.println(b == c);


    }

}
