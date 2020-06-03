package com.thinking_in_java.genericity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static com.thinking_in_java.util.Sets.*;

import static com.thinking_in_java.genericity.CustomColor.*;

/**
 * @program: basicDemo
 * @description: java编程思想作业完成
 * @author: 无能狂怒
 * @create: 2020-05-31 17:39
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-test.xml")
public class WorkAndTest {


    @Test
    public void test1() {
        EnumSet<CustomColor> es1 = EnumSet.range(RED, BLUE);
        EnumSet<CustomColor> es2 = EnumSet.range(YELLOW, WHITE);
        Set<CustomColor> complement = complement(es1, es2);
        complement.forEach((s) -> System.out.println(s));
        System.out.println("<---------------------------------->");

        System.out.println(RED.compareTo(YELLOW));
    }

    @Test
    public void test2(){
        HashSet<Integer> hs1 = new HashSet<Integer>();
        hs1.add(1);
        hs1.add(2);
        hs1.add(3);
        hs1.add(4);
        hs1.add(5);
        HashSet<Integer> hs2 = new HashSet<Integer>();
        hs2.add(3);
        hs2.add(4);
        hs2.add(5);
        hs2.add(6);
        hs2.add(7);
        Set<Integer> complement1 = complement(hs1, hs2);
        complement1.forEach(s -> System.out.println(s));
        complement("aa","bb");

    }


}
