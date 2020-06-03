package com.transitory.container;

import com.transitory.pojo.TestPojo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: basicDemo
 * @description: 初始化语句
 * @author: 无能狂怒
 * @create: 2020-04-04 11:32
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-test.xml")
public class ListInit {



    @Test
    public void testInit(){
        List<String> list = new ArrayList<String>(2){{
            add("a");
            add("b");
            add("c");
        }};

        System.out.println(list);
    }

    @Test
    public void testInit2(){
        TestPojo pojo = new TestPojo(){{
            setAge(12);
            setName("lisi");
            setGender("男");
        }};

        System.out.println(pojo);
    }


}
