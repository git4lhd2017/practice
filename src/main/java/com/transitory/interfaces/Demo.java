package com.transitory.interfaces;

import com.transitory.pojo.TestPojo;
import org.junit.Test;

/**
 * @program: basicDemo
 * @description: 运行测试类
 * @author: 无能狂怒
 * @create: 2020-02-22 17:07
 **/
public class Demo {


    
    /** 
    * @Description: 测试方法，常见接口实例，创建没重写接口默认实现的接口实现类
    * @Param: [] 
    * @return: void 
    * @Author: 无能狂怒 
    * @Date: 2020/2/22 
    */
    @Test
    public void test1(){

        DefaultImplInterface demo1 = new DefaultImplInterface() {
            @Override
            public String getDescription() {
//                return super.getDescription();
                return "custom string";
            };

            @Override
            public String lambdaTest() {
                return "trouble";
            }
        };


        System.out.println(demo1.getDescription());

        Interfaceimpl impl1 = new Interfaceimpl();

        System.out.println(impl1.getDescription());



    }


    @Test
    public void Test2() {
        DefaultImplInterface demo2 = () -> {return "this is lambda!";};

        System.out.println(demo2.pojo);
//        demo2.a += 10;报错，不能修改final常量
//        demo2.pojo = new TestPojo("new",1,"男");报错，同上

        demo2.pojo.setAge(20);
        demo2.pojo.setName("setter");
        demo2.pojo.setGender("男");
        System.out.println(demo2.pojo);

        //这里并没有修改demo2里的pojo实际值（也就是引用地址），而是修改了其引用地址里的数据，所以不报错。
    }


}
