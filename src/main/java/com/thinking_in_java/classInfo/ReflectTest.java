package com.thinking_in_java.classInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @program: basicDemo
 * @description: 反射的练习
 * @author: 无能狂怒
 * @create: 2020-05-28 19:24
 **/
public class ReflectTest {

    private static int constructorsCount = 0;
    private static int fieldsCount = 0;
    private static int methodsCount = 0;

    /**
    * @Description: 反射练习
    * @Param: [args]
    * @return: void
    * @Author: 无能狂怒
    * @Date: 2020/5/28
    */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {

        Class<?> dogclass = Class.forName("com.animal.pets.Dogs");
        Constructor<?>[] constructors = dogclass.getDeclaredConstructors();
        //Object[] dogs = new Object[constructors.length];
        for (Constructor<?> constructor : constructors) {
            System.out.println((++constructorsCount)+"构造方法参数类型：");
            Class<?>[] types = constructor.getParameterTypes();
            //dogs[constructorsCount-1] = constructor.newInstance(Arrays.toString(types));
            //todo 不能自动封装构造参数然后实例化；
            for (Class<?> type : types) {
                System.out.println(type);
            }
        }
        Object dog = constructors[0].newInstance(4, "白色", "嗷呜！", "小白");
        System.out.println(dog);
        System.out.println("-------------constructor-end------------------");
        Field[] fields = dogclass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getType().getName()+":"+field.getName());
            //根据属性类型更改属性值
            if(field.getType().getName() == "int"){
                field.set(dog,99);
            }
            //根据属性名更改属性值
            if (field.getName() == "cry"){
                field.set(dog,"我成精了！");
            }
        }
        System.out.println(dog);
        System.out.println("----------field-end---------------");
        Method[] methods = dogclass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName()+"=="+Arrays.toString(method.getParameterTypes()));
        }

        Method jump = dogclass.getMethod("jump");
        jump.invoke(dog);
        Method jump2 = dogclass.getMethod("jump",int.class);
        jump2.invoke(dog,5);
        System.out.println("-------------method-end-----------------");
    }







}
