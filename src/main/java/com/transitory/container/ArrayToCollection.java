package com.transitory.container;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: basicDemo
 * @description: 将数组转换成集合的办法
 * @author: 无能狂怒
 * @create: 2020-03-04 00:44
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-test.xml")
public class ArrayToCollection {

    private int[] ints = {9,8,7,6,5,4,3,2,1};

    private Integer[] integers = {1,2,3,4,5,6,7,8,9};

    private String[] strings = {"H","E","L","L","O","J","A","V","A"};


    /**
    * @Description: 针对Arrays.aslist API进行了测试说明，指定长度，无法操作结构，可以操作数据，直接影响到源数据
    * @Param: []
    * @return: void
    * @Author: 无能狂怒
    * @Date: 2020/3/4
    */
    @Test
    public void firstMethod(){
        List<Integer> interlist = Arrays.asList(integers);
        //如果数组中存的是基本数据类型，那么转换时只能转换成数组，我是没搞懂为什么，一度以为自己的API调错了，
        List<int[]> intlist = Arrays.asList(this.ints);
        List<String> stringlist = Arrays.asList(this.strings);

        System.out.println("打印转换之后的集合：");
        interlist.forEach((i)-> System.out.print(i));
        System.out.println();
        intlist.forEach((i)-> System.out.print(i));
        //可以看到这个集合很诡异的只有一个数组的地址，
        System.out.println();
        stringlist.forEach((i)-> System.out.print(i));

        //先不管那个数组的问题，如果要向集合中添加数据呢
       // inters.add(0);
       // ints.add(new int []{000000});//这个只准添加数组
       // strings.add("!");

        //运行报错了 UnsupportedOperationException - 不支持操作异常 ，不能操作对这个集合进行增加

//        inters.remove(0);
//        ints.remove(0);
//        strings.remove(0);

        //运行报错了 UnsupportedOperationException - 不支持操作异常 ，也不能操作对这个集合进行删除

        interlist.set(0,0);
        intlist.set(0,new int[]{1,2,3,4,5});
        stringlist.set(0,"h");

        System.out.println("<<<<<打印修改之后的集合>>>>>");
        interlist.forEach((i)-> System.out.print(i));
        System.out.println();
        intlist.forEach((i)-> System.out.println(i));
        intlist.forEach((i)-> System.out.println(Arrays.toString(i)));
        stringlist.forEach((i)-> System.out.print(i));

        //看起来是ok了，那么如果我们再去打印一下我们本来的数组呢？
        System.out.println("打印原数据");
        System.out.println(Arrays.toString(integers));
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(strings));

        //是的，除了那个是数组的集合，其余的都变了，所以我猜测这个新集合是直接把原数组内的各元素引用地址给拿到了。
        //刚才去看了源码，集合的底层实现是数组，原数组的扩容等操作都被封装在集合的类中，所以可以调用API进行扩容，
        // 而这个方法会返回一个内部类的引用过来，该内部类继承了AbstractList类，直接将原数组作为底层数组，并且重写大部分的方法，
        //包括获取值，get，set，但是没有重写add，remove等操作集合结构的方法，所以会直接使用父类中的方法，而父类中的方法即是抛出一个不可操作异常

    }

    @Test
    public void secondMethod(){
        //解决办法就是再使用一个集合，用新集合的addAll方法，或者在新集合构造器中直接添加。

    }


}
