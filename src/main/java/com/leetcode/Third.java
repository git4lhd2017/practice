package com.leetcode;

/**
 * @program: basicDemo
 * @description: 最长的不重复字符串，给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author: 无能狂怒
 * @create: 2020-07-08 17:51
 **/
public class Third {

    public static void main(String[] args) {
        String demo = "abceader";
        System.out.println(lengthOfLongestSubstring1(demo));
        System.out.println("---------------分割线--------------");
        System.out.println(lengthOfLongestSubstringSolution2(demo));
    }

    /**
     * @Description:  第一次没写出来，看了评论后又学着写的
     * @Param:  String s
     * @return:  int length
     * @Author: 无能狂怒
     * @Date: 2020/7/8
     */
    public static int lengthOfLongestSubstring1(String s){
        char[] chars = s.toCharArray();
        //首先，既然要用滑动窗口，就必须要确定左右边界以及滑动指针,以及获得的最大长度
        int longest=0,leftBorder=0,rightBorder=0,pulley=0,length = s.length();
        //然后创建两个循环，外循环用来确定右边界（1），内循环用来确定左边界（2）
        for (;rightBorder<length;rightBorder++) {
            for (pulley = leftBorder;pulley<rightBorder;pulley++) {
                //使用滑轮从左边界滑到右边界依次判重；
                if(chars[pulley] == chars[rightBorder]) {
                    //如果碰到了重复值就将窗口左边界向右移动一位

                    leftBorder = pulley + 1;
                    break;
                    //ps:这个地方是最容易迷糊的，即直接移动窗口会不会丢掉含有前面部分的最长，答案是不会，
                    // 前面部分到重复位置的前一位已经是最长可用元素，且最长值已被记录。
                }
            }
            if(rightBorder - leftBorder + 1 >longest)
                longest = rightBorder - leftBorder + 1;
        }
        return longest;
    }



    /**
    * @Description: 评论思路，动态规划，双指针滑动窗口
    * @Param: String s
    * @return: int longest
    * @Author: 无能狂怒
    * @Date: 2020/7/8
    */
    public int lengthOfLongestSubstringSolution(String s) {
        int  size=s.length(),start=0,end=0,k,max=0;
        char[] ss = s.toCharArray();
        for(;end<size;end++){
            for(k = start;k<end;k++) {
                if (ss[k] == ss[end]) {
                    start = k + 1;
                    break;
                }
            }

            if(end - start + 1 > max)
                max = end - start + 1;
        }
        return max;
    }



    /**
     * @Description: 评论思路，动态规划，双指针滑动窗口，基于数组但是只使用于ASCLL表
     * @Param: String s
     * @return: int longest
     * @Author: 无能狂怒
     * @Date: 2020/7/8
     */
    public static int lengthOfLongestSubstringSolution2(String s) {
        int longest=0,start=0;
        //基于数组记录元素出现下标
        int[] indexs = new int[128];
        for (int i = 0; i < 128;i++ ) {
            indexs[i] = -1;
            //初始所有下标为-1，防止数据错误
        }

        for (int i =0;i<s.length();i++) {
            int index = s.charAt(i);
            //先将此元素转换为字节也就对应之前建立数组的下标
            start = Math.max(start,indexs[index]+1);
            //根据元素是否重复确定左边界
            longest = Math.max(longest,i - start + 1);
            //记录最长字符串段
            indexs[index] = i;
            //更新元素索引
        }

        return longest;
    }


}
