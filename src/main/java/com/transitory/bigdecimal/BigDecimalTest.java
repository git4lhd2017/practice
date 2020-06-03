package com.transitory.bigdecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

/**
 * @program: basicDemo
 * @description: bigdecimal学习测试类，关于小数运算的精度问题
 * @author: 无能狂怒
 * @create: 2020-03-03 18:16
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-test.xml")
public class BigDecimalTest {

    /** 
    * @Description: 此方法说明了在进行浮点数的运算时可能会丢失掉精度，原因暂时未知，只知道是二进制时的算法问题
    * @Param: [] 
    * @return: void 
    * @Author: 无能狂怒 
    * @Date: 2020/3/3 
    */
    @Test
    public void noDecimalArithmetic(){
        System.out.println("not use Bigdecimal to arithmetic!");
        System.out.println(0.06+0.01);//0.0699999999999999
        System.out.println(1.0-0.42);//0.5800000000000001
        System.out.println(4.015*100);//401.49999999999994
        System.out.println(303.1/1000);//0.30310000000000004
    }



    @Test
    public void useBigDecimalArithmetic(){
        System.out.println("use BigDecimal to Arithmetic!");
        System.out.println(BigDecimal.valueOf(0.01).add(BigDecimal.valueOf(0.06)));
        System.out.println(BigDecimal.valueOf(1.0).subtract(BigDecimal.valueOf(0.42)));
        System.out.println(BigDecimal.valueOf(4.015).multiply(BigDecimal.valueOf(100)));
        System.out.println(BigDecimal.valueOf(303.1).divide(BigDecimal.valueOf(1000)));
    }


    @Test
    public void useMethod(){
        System.out.println("use method to arithmetic!");
        System.out.println(this.bigAdd(0.01,0.06));
        System.out.println(this.bigSub(1.0,0.42));
        System.out.println(this.bigMul(4.015,100));
        System.out.println(this.bigDiv(303.1,1000));
    }



    /**
    * @Description: 抽取出一个运算方法
    * @Param: [x, y]
    * @return: java.math.BigDecimal
    * @Author: 无能狂怒
    * @Date: 2020/3/3
    */
    public double bigAdd(double x,double y){
        return  Double.valueOf(BigDecimal.valueOf(x).add(BigDecimal.valueOf(y)).toString());
    }
    public double bigSub(double x,double y){
        return  Double.valueOf(BigDecimal.valueOf(x).subtract(BigDecimal.valueOf(y)).toString());
    }
    public double bigMul(double x,double y){
        return  Double.valueOf(BigDecimal.valueOf(x).multiply(BigDecimal.valueOf(y)).toString());
    }
    public double bigDiv(double x,double y){
        return  Double.valueOf(BigDecimal.valueOf(x).divide(BigDecimal.valueOf(y)).toString());
    }

}
