package com.transitory.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 * @program: basicDemo
 * @description: 数组的查找练习
 * @author: 无能狂怒
 * @create: 2020-02-27 15:26
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-test.xml")
public class ArraySearchTest {

    private int[]arr = {2,4,6,8,9,12,15,16,19};


    @Test
    public void Test1(){
        int value1 = 13,value2 = 15,value3 = 11;

        System.out.println("自定义递归二分查找");
        int i = arrayBinarySearch(arr, value1);
        if(i == -1)
            System.out.println("查询结果不存在");
        else
            System.out.println(value1+"在此数组的"+i+"号下标位！");

        System.out.println("<<<--------------------分割线----------------------->>>");


        System.out.println("自定义while循环二分查找");
        int j = arrayBinarySearch2(arr,value2);

        if(j == -1)
            System.out.println("查询结果不存在");
        else
            System.out.println(value2+"在此数组的"+j+"号下标位！");

        System.out.println("<<<--------------------分割线----------------------->>>");

        System.out.println("java工具类二分查找");

        int k = Arrays.binarySearch(arr, value3);

        if(k < 0)
            System.out.println("查询结果不存在,假设此数值存在，它可能在第"+(-k)+"个位置");
        //工具类提供一个返回值，当返回值>=0时，此值为要查找的值在该数组的下标，当返回值<0时，标示该值不存在此数组中，但假设存在于该返回值的正数值的元素号，非下标号
        else
            System.out.println(value3+"在此数组的"+k+"号下标位！");

        System.out.println("<<<--------------------分割线----------------------->>>");


    }




    public int arrayBinarySearch2(int[] arr,int i){

        int begin = 0, end = arr.length-1;

        while (begin < end){
            if (i == arr[begin])
                return begin;
            if(i == arr[end])
                return end;
            int mid = (begin + end)/2;
            if(i == arr[mid])
                return mid;
            if (i < arr[mid]){
                begin += 1;
                end = mid -1;
            }else{
                begin = mid + 1;
                end -= 1;
            }
        }
        return -1;
    }




    /** 
    * @Description: 递归方式查询 
    * @Param: [arr, i]
    * @return: int ，-1为数组内无此值，其余为值下标
    * @Author: 无能狂怒 
    * @Date: 2020/2/27 
    */
    public static int arrayBinarySearch(int[]arr ,int i){
        int begin = 0;
        int end = arr.length-1;
        if (i<arr[begin]||i>arr[end])
            return -1;
        if(i == arr[begin])
            return begin;
        if(i == arr[end]){
            return end;
        }
        return binarySearch(begin,end,i,arr);
    }

   /**
   * @Description: 递归调用方法
   * @Param: [begin, end, i, arr]
   * @return: int
   * @Author: 无能狂怒
   * @Date: 2020/2/27
   */
    public static int binarySearch(int begin,int end,int i,int[] arr){
        System.out.println("调用了一次二分查找，此时的开头下标为"+begin+",结束下标为"+end);
        if(begin == end || end == begin+1 || begin + 2 ==end) {
            if (i == arr[begin])
                return begin;
            else if(i == arr[end])
                return end;
            else
                return -1;
        }
        int mid = (begin + end) / 2;

        if( i == arr[mid])
            return mid;
        else if(begin +2 == end)
            return -1;
        else
            return i < arr[mid] ? binarySearch(begin+1,mid-1,i,arr) :binarySearch(mid+1,end-1,i,arr);
    }

}
