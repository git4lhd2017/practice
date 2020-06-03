package com.thinking_in_java.util;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;


/**
 * @program: basicDemo
 * @description: 集合工具
 * @author: 无能狂怒
 * @create: 2020-05-31 17:34
 **/

public class Sets {

    /**
     * @Description: 返回两个set集合的并集
     * @Param: Set<E> s1,Set<E> s2
     * @return: Set<E> newset
     * @Author: 无能狂怒
     * @Date: 2020/5/31
     */
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> set = new HashSet<>(s1);
        set.addAll(s2);
        return set;
    }

    /**
     * @Description: 返回两个set集合的交集
     * @Param: Set<E> s1,Set<E> s2
     * @return: Set<E> newset
     * @Author: 无能狂怒
     * @Date: 2020/5/31
     */
    public static <E> Set<E> intersection(Set<E> s1, Set<E> s2) {
        Set<E> set = new HashSet<>(s1);
        set.retainAll(s2);
        return set;
    }

    /**
     * @Description: s1减去s2
     * @Param: Set<E> s1,Set<E> s2
     * @return: Set<E> newset
     * @Author: 无能狂怒
     * @Date: 2020/5/31
     */
    public static <E> Set<E> difference(Set<E> s1, Set<E> s2) {
        Set<E> set = new HashSet<>(s1);
        set.removeAll(s2);
        return set;
    }

    /**
     * @Description: 返回两个set集合的差集
     * @Param: Set<E> s1,Set<E> s2
     * @return: Set<E> newset
     * @Author: 无能狂怒
     * @Date: 2020/5/31
     */
    public static <E> Set<E> complement(Set<E> s1, Set<E> s2) {
        String classname = s1.getClass().getSimpleName();
        System.out.println(classname);
        Set<E> set = null;
        if ("HashSet".equals(classname)) {
            HashSet<E> s11 = (HashSet<E>) s1;
            set = (Set<E>) s11.clone();
        } else if ("RegularEnumSet".equals(classname)) {
            EnumSet s12 = (EnumSet) s1;
            set = s12.clone();
        }

        return difference(union(set, s2), intersection(set, s2));
    }

    public static <E,T> Set<E> complement( T s1, T s2) {
        String classname = s1.getClass().getSimpleName();
        Set<E> set = null;
        if ("HashSet".equals(classname)) {
            HashSet<E> s11 = (HashSet<E>) s1;
            set = (Set<E>) s11.clone();
        } else if ("RegularEnumSet".equals(classname)) {
            EnumSet s12 = (EnumSet) s1;
            set = s12.clone();
        }else{
            throw new IllegalArgumentException("类型不对！");
        }

        return difference(union(set, (Set<E>) s2), intersection(set, (Set<E>) s2));
    }
}
