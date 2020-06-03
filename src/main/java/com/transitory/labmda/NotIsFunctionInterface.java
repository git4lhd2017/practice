package com.transitory.labmda;

/**
 * @program: basicDemo
 * @description: 非函数接口
 * @author: 无能狂怒
 * @create: 2020-02-22 17:58
 **/
public interface NotIsFunctionInterface {

    long factorial(int a,int b);


    default long factorial2(int a){
        return a << test();
    };

    //static methods contain interface class only
    static int test(){
        return 3;
    };

}
