package com.transitory.container;

import java.util.Set;
import java.util.TreeSet;

/**
 * @program: basicDemo
 * @description: treeSet自定义排序
 * @author: 无能狂怒
 * @create: 2020-04-20 22:41
 **/
public class TreeSetTest {

    private Set<TreeSetPojo> test = new TreeSet<TreeSetPojo>();

    public static void main(String[] args) {
        TreeSetPojo p1 = new TreeSetPojo("p1",20);
        TreeSetPojo p2 = new TreeSetPojo("p2",30);
        TreeSetPojo p3 = new TreeSetPojo("p3",28);
        TreeSetPojo p4 = new TreeSetPojo("p4",15);
        TreeSetPojo p5 = new TreeSetPojo("p5",20);

        TreeSetTest testP = new TreeSetTest();

        testP.test.add(p5);
        testP.test.add(p2);
        testP.test.add(p1);
        testP.test.add(p3);
        testP.test.add(p4);

        System.out.println(testP.test);
    }



}
