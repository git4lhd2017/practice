package com.transitory.finallydescription;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: basicDemo
 * @description: finally的解释与说明
 * @author: 无能狂怒
 * @create: 2020-02-24 13:30
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-test.xml")
public class FinallyTest1 {


    /** 
    * @Description:调用运行测试方法
    * @Param: [] 
    * @return: void 
    * @Author: 无能狂怒 
    * @Date: 2020/2/24 
    */
    @Test
    public void call(){
//        return的生效语句，详请请看方法注释说明 return 30；
        System.out.println(finalyTest1());

//        调用详请请看方法说明 return 40，这里可以看出，try语句里的return语句也执行了，只不过没有返回，
//        也就是说执行语句是try.return执行->（无异常）catch.return不执行-> finally.return语句执行->finally语句返回
        System.out.println(finallyTest2());

//        try有异常的return生效语句及执行顺序 return 45 与try的return执行流程一样，只不过跳到了catch里执行
        System.out.println(finallyTest3());
    }






    /**
    * @Description: 测试说明return在try语句中的执行顺序，先测试都有return 语句的话返回的到底是那个return语句
    * @Param: []
    * @return: int 20为try返回，25为catch返回，30为finally返回 30！
    * @Author: 无能狂怒
    * @Date: 2020/2/24
    */
    int finalyTest1(){
        int a = 10;

        try {
            System.out.println("try块执行了！");
            return 20;
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("catch块执行了！");
            return 25;
        } finally {
            System.out.println("final块执行了！");
            return 30;
        }

    }


    /**
    * @Description: 那么其他语句块里的return语句到底有没有执行呢！
    * @Param: []
    * @return: int 20为try返回，25为catch返回，30为finally返回
    * @Author: 无能狂怒
    * @Date: 2020/2/24
    */
    int finallyTest2(){
        int a = 10;


        try {
            return a += 10;
        } catch (Exception e) {
            e.printStackTrace();
            return a += 15;
        } finally {
            return a += 20;
        }

    }


    /**
     * @Description: 那么如果try语句里有异常呢？
     * @Param: []
     * @return: int 20为try返回，25为catch返回，30为finally返回
     * @Author: 无能狂怒
     * @Date: 2020/2/24
     */
    int finallyTest3(){
        int a = 10;


        try {
            //除零运行时异常
            int b = 20/0;
            return a += 10;
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("/0 exception!");
            return a += 15;
        } finally {
            return a += 20;
        }

    }



}
