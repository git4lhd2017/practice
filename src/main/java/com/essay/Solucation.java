package com.essay;

/**
 * @program: basicDemo
 * @description: 2020年7月3日21:11:36
 * @author: 无能狂怒
 * @create: 2020-07-03 21:11
 **/
public class Solucation {

    public static void main(String[] args) {
        long[] nums = {142,156,111,856,243};
        long max = getMax(nums);
        System.out.println(max);
    }

    public static long getMax(long[] nums){
        long max = nums[0];
        for (int i = 1;i<nums.length;i++) {
            max = (max > nums[i] ? max : nums[i]);
        }
        return max;
    }

}
