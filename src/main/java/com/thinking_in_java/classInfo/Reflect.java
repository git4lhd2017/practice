package com.thinking_in_java.classInfo;


import com.animal.pets.Cats;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: basicDemo
 * @description: 简单的反射调用
 * @author: 无能狂怒
 * @create: 2020-05-28 14:15
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-test.xml")
public class Reflect {


    @Test
    public void test1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> cat = Class.forName("com.animal.pets.Cats");

        System.out.println(cat);

        Constructor<?>[] constructors = cat.getConstructors();//获得构造参数
        Field[] fields = cat.getFields();//获得域对象(非私有)
        Field[] fields2 = cat.getDeclaredFields();//获得域对象（所有的）
        Method[] methods = cat.getMethods();//获得方法

        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("-----------------------------------");
        System.out.println(fields.length);
        System.out.println(fields2.length);
        for (Field field : fields2) {
            field.setAccessible(true);
            System.out.println(field.toString());
        }
        System.out.println("------------------------------------");
        for (Method method : methods) {
            System.out.println(method);
        }




    }


}
