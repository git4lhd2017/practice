package com.transitory.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: basicDemo
 * @description: 数组的排序联系
 * @author: 无能狂怒
 * @create: 2020-02-27 14:52
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-test.xml")
public class ArraySortTest {

    /** 
    * @Description: ，三种方式创建数组，调用排序的测试方法
    * @Param: [] 
    * @return: void 
    * @Author: 无能狂怒 
    * @Date: 2020/2/27 
    */
    @Test
    public void test(){
        //创建一个随机int对象，用来填充arr2数组
        Random r = new Random();
        int[] arr1 = new int[]{12,21,13,4,15};
        int[] arr2 = new int[6];
        for (int i=0;i < arr2.length;i++){
            //arr2数组赋值
            arr2[i] = r.nextInt(30);
        }
        int[] arr3 = {11,2,42,24,8,4,1};

        System.out.println("没排序之前的数值分别是:");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println("---------------------------------------");
        bubblingSort(arr1);
        choiceSort(arr2);
        Arrays.sort(arr3);//调用java工具类
        System.out.println("排序之后的数组分别是：");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }
    

    
    /** 
    * @Description: 冒泡排序法，由小到大 
    * @Param: [arr] 
    * @return: void 
    * @Author: 无能狂怒 
    * @Date: 2020/2/27 
    */
    public static void bubblingSort(int[] arr){
        int temp = arr[0];
        for (int i = arr.length-1;i>=0;i--){
            for (int j = 0;j<i;j++){
                //从头往后冒泡，将大值冒出来
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    
    
    /** 
    * @Description: 选择排序法，由小到大
    * @Param: [arr] 
    * @return: void 
    * @Author: 无能狂怒 
    * @Date: 2020/2/27 
    */
    public static void choiceSort(int[] arr){
        int temp = arr[0];
        for (int i = 0; i<arr.length - 1; i++){
            for (int j = i+1;j<arr.length;j++){
                //正序选择，选小值
                if(arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


}
