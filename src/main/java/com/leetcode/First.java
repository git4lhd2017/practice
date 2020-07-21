package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: basicDemo，给定一整数数组和目标值
 * @description: 两数之和
 * @author: 无能狂怒
 * @create: 2020-07-03 01:18
 **/
public class First {


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 4};
        int target = 8;
        int[] solution = solution3(nums, target);
        System.out.println(Arrays.toString(solution));
    }

    public static int[] solution1(int[] nums, int target) {
        //要求答案返回为原数组下标！我服了
        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;
        for (; ; ) {
            if (start >= end) {
                throw new IllegalArgumentException("No two sum solution");
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else if (nums[start] + nums[end] == target) {
                return new int[]{start, end};
            }
        }
    }

    public static int[] solution2(int[] nums, int target) {
        //暴力解法,时间复杂度O(n*n),空间复杂度)(1)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] solution3(int[] nums, int target) {
        //leetcode题解，两遍哈希表，空间复杂度O(n),时间复杂度O(n)
        //解为重复元素问题：从前向后遍历数组进行排除，而哈希表内也是此顺序，
        //由于哈希表不可重复，所以记录的是最后一个的索引，而遍历时i为第一次出现的索引
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");

    }

    public static int[] solution4(int[] nums, int target) {
        //leetcode题解，一遍哈希表，空间复杂度O(n),时间复杂度O(n)
        //解为重复元素问题：此循环是先判断再添加进哈希表，所以如果有重复元素为解的情况，会在未更新索引前返回正确答案
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");


    }

}

