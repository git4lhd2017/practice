package com.transitory.container;

import java.util.*;

/**
 * @program: basicDemo
 * @description: 数组交，并，差运算
 * @author: 无能狂怒
 * @create: 2020-05-29 15:16
 **/
public class ArrayUnion {

    public Object[] Union(Object[] o1,Object[] o2){
        Set set = new HashSet();
        for (Object o : o1) {
            set.add(o);
        }
        for (Object o : o2) {
            set.add(o);
        }
        return set.toArray();
    }

    public Object[] Intersection(Object[] o1,Object[] o2){
        List list = new ArrayList();
        for (Object o : o1) {
            for (Object o3 : o2) {
                if (o3.equals(o))
                    list.add(o);
            }
        }
        return list.toArray();
    }



}
