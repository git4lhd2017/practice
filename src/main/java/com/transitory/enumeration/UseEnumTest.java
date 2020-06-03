package com.transitory.enumeration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 * @program: basicDemo
 * @description: 枚举类测试类
 * @author: 无能狂怒
 * @create: 2020-03-03 23:37
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-test.xml")
public class UseEnumTest {

    @Test
    public void test(){
        System.out.println(AgeTest.SHAONIAN);

        AgeTest[] ages = AgeTest.values();
        System.out.println(Arrays.toString(ages));
    }


    @Test
    public void test2(){
        System.out.println(AgeTest.QINGNIAN);
        useMyEnum(AgeTest.QINGNIAN);
    }


    public void useMyEnum(AgeTest ageTest){
        int[] age = ageTest.getAge();

        switch (ageTest.getDesc()){
            case "少年":
                System.out.println("这是少年时期，年龄在"+age[0]+"~"+age[age.length-1]+"之间！");
                break;
            case "幼年":
                System.out.println("这是幼年时期，年龄在"+age[0]+"~"+age[age.length-1]+"之间！");
                break;
            case "青年":
                System.out.println("这是青年阶段，年龄在"+age[0]+"~"+age[age.length-1]+"之间！");
                break;
            default:
                System.out.println("我拦截不到啊！");
                break;
        }
    }

}
