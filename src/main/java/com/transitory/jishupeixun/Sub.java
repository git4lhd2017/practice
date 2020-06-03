package com.transitory.jishupeixun;

/**
 * @program: basicDemo
 * @description: 临时复制代码查看
 * @author: 无能狂怒
 * @create: 2020-03-26 13:12
 **/




class Super {
    public Number getLenght() { return new Integer(4); }
}

@SuppressWarnings("all")
public class Sub extends Super {

//    public Integer getLenght() { return new Integer(5); }


    public Long getLenght() { return new Long(5); }


    public static void main(String[] args) {
        Super sooper = new Super();
        Sub sub = new Sub();
        System.out.println(sooper.getLenght().toString() + "," +
                sub.getLenght().toString() );
    }
}
