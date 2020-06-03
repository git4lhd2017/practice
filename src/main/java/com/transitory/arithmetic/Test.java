package com.transitory.arithmetic;

/**
 * @program: basicDemo
 * @description: Test
 * @author: 无能狂怒
 * @create: 2020-03-13 15:00
 **/
public class Test {




        public static void main(String[] args) {
            String text = "199";
            try {
                text = text.concat(".5");
                double decimal = Double.parseDouble(text);
                text = Double.toString(decimal);
                int status = (int) Math.ceil(Double.valueOf(text).doubleValue());
                int status2 = (int)Math.floor(Double.valueOf(text).doubleValue());
                System.out.println(status);
                System.out.println(status2);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
        }



}
