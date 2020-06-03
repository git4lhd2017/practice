package com.transitory.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: basicDemo
 * @description: stringAPI的测试了解类
 * @author: 无能狂怒
 * @create: 2020-03-04 14:44
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-test.xml")
public class StringAPI {

    private String test = "this is test!";

    @Test
    public void test_replace(){
        String s1 = test.replace(" ", "");
        String s2 = test.replace(' ',(char)0);
        System.out.println(s1+"\n"+s2);
    }


    /**
    * @Description: replace与replaceAll的区别在于，replaceAll支持使用正则表达式来替换
    * @Param: []
    * @return: void
    * @Author: 无能狂怒
    * @Date: 2020/3/4
    */
    @Test
    public void test_replaceAll(){
        String s1 = test.replaceAll("\\s", "_");
        System.out.println(s1);

    }

    /**
    * @Description: repalceFirst同样支持正则表达式 ，但是只替换第一个捕获到的元素
    * @Param: []
    * @return: void
    * @Author: 无能狂怒
    * @Date: 2020/3/4
    */
    @Test
    public void test_replaceFirst(){
        String s1 = test.replaceFirst("\\s", "_");
        System.out.println(s1);

    }

}
