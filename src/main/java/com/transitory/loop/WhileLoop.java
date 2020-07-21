package com.transitory.loop;

/**
 * @program: basicDemo
 * @description: while-loop，while内条件成立则循环
 * @author: 无能狂怒
 * @create: 2020-07-03 02:50
 **/
public class WhileLoop {

    public static void main(String[] args) {

        int a = 3, b = 7;
        while (a > 1 && b > 2) {

            System.out.println(a+","+b);
            a--;
            b--;
            //3,7
            //2,6
        }

        a = 3;
        b = 7;
        while (a > 1 || b > 2) {

            System.out.println(a+","+b);
            a--;
            b--;
            //3,7
            //2,6
            //1,5
            //0,4
            //-1,3
        }

    }

}
