package com.transitory.nowcoder;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @program: basicDemo
 * @description: 字符串类正则判断
 * @author: 无能狂怒
 * @create: 2020-03-08 02:06
 **/
public class StringRegex {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String p = sc.nextLine();
        String t = sc.nextLine();
        StringRegex s = new StringRegex();
        System.out.println(s.stringRegex(p, t));
    }

    public int stringRegex(String p,String t){
        String a = p.replace("*","[\\S]*");
        String r = a.replace("?", ".");
        boolean matches = Pattern.matches(r,t);
        return matches?1:0;
    }

}
