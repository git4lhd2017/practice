package com.transitory.nowcoder;


import java.util.Scanner;

/**
 * @program: basicDemo
 * @description: 牛客网编程题
 * @author: 无能狂怒
 * @create: 2020-03-08 00:47
 **/
public class BooleanReturn {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        BooleanReturn b = new BooleanReturn();
        System.out.println(b.testboolean(s));
    }


    public String testboolean(String s) {

        String[] s1 = s.split(" ");
        if (s1.length < 3) {
            if (s1.length == 1){
                if ("true".equals(s1[0]) || "false".equals(s1[0]))
                    return s1[0];
                else
                    return "error";
            }
            return "error";
        } else if (s1.length % 2 == 0)
            return "error";
        else
            return recursion(s1);
    }


    private String recursion(String[] s) {
        if (s.length == 1) {
            return s[0];
        }
        for (int j = 0; j < 3; j++) {
            if (j < 2) {
                for (int i = 1; i < s.length; i += 2) {
                    if (j == 0) {
                        if ("and".equals(s[i])) {
                            String and = and(s[i - 1], s[i + 1]);
                            if (and.equals("error")) {
                                return "error";
                            } else {
                                return recursion(newStringArr(s, i, and));
                            }
                        }
                    } else if (j == 1) {
                        if ("or".equals(s[i])) {
                            String or = or(s[i - 1], s[i + 1]);
                            if (or.equals("error")) {
                                return "error";
                            } else {
                                return recursion(newStringArr(s, i, or));
                            }
                        }
                    }
                }
            } else {
                return "error";
            }
        }
        return "error";
    }

    private String[] newStringArr(String[] old, int index, String temp) {
        String[] newarr = new String[old.length - 2];
        for (int i = 0; i < newarr.length; i++) {
            if (i < (index - 1)) {
                newarr[i] = old[i];
            } else if (i == (index - 1)) {
                newarr[i] = temp;
            } else {
                newarr[i] = old[i + 2];
            }
        }
        return newarr;
    }

    public String and(String a, String b) {
        if (a.equals("true")) {
            if (b.equals("true")) {
                return "true";
            } else if (b.equals("false")) {
                return "false";
            } else {
                return "error";
            }
        } else if (a.equals("false")) {
            if (b.equals("true")) {
                return "false";
            } else if (b.equals("false")) {
                return "false";
            } else {
                return "error";
            }
        } else {
            return "error";
        }
    }

    public String or(String a, String b) {

        if (a.equals("true")) {
            if (b.equals("true")) {
                return "false";
            } else if (b.equals("false")) {
                return "true";
            } else {
                return "error";
            }
        } else if (a.equals("false")) {
            if (b.equals("true")) {
                return "true";
            } else if (b.equals("false")) {
                return "false";
            } else {
                return "error";
            }
        } else {
            return "error";
        }

    }


}
