package com.transitory.recursion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: basicDemo
 * @description: 递归测试类
 * @author: 无能狂怒
 * @create: 2020-02-22 13:37
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-test.xml")
public class Recursion {


   /**
   * @Description: 递归调用方法,将5+4+3+2+1使用for跟递归打印
   * @Param: []
   * @return: void
   * @Author: 无能狂怒
   * @Date: 2020/2/22
   */
    @Test
    public void one () {

        int sum = 0;
        //1,使用for
        for (int i=5;i>0;i--){
            sum+=i;
        }
        System.out.println(sum);
        System.out.println(recursion1(5));


    }


    /**
    * @Description: 递归方法
    * @Param: [i]
    * @return: int
    * @Author: 无能狂怒
    * @Date: 2020/2/22
    */
    public int recursion1(int i){

        if(i>1){
            return i + recursion1(i-1);
        }else{
            return i;
        }

    }


}
