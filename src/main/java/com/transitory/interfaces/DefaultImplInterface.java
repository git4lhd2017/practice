package com.transitory.interfaces;


import com.transitory.pojo.TestPojo;

/**
 * @program: basicDemo
 * @description: 测试接口
 * @author: 无能狂怒
 * @create: 2020-02-22 16:49
 **/
public interface DefaultImplInterface {

    public int a = 5;
    public TestPojo pojo = new TestPojo("interface",0,"notGender");



    final String DESCRIPTION = "inteface constant";



   default String getDescription(){
       return this.DESCRIPTION;
   }



   String lambdaTest();


}
