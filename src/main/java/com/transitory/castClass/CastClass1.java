package com.transitory.castClass;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.java2d.pipe.SpanIterator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-test.xml")
public class CastClass1 {


    /**
     *
     * 结论：+= 与=+ 在int以下类型时不同，int及int以上类型时相同
     *
     */

    @Test
    public void one (){

        byte a = 1;
        short b = 1;
        char c = 1;
        int d = 1;


        System.out.println(a += 1);
//      System.out.println(a = a + 1); 报错

        System.out.println(b += 1);
//      System.out.println(b = b + 1); 报错

        System.out.println(c += 1);
//        System.out.println(c = c + 1); 报错

        System.out.println(d += 1);
        System.out.println(d = d + 1);


    }



}
