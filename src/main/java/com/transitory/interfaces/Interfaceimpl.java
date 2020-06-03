package com.transitory.interfaces;

/**
 * @program: basicDemo
 * @description: 接口实现类
 * @author: 无能狂怒
 * @create: 2020-02-22 17:09
 **/
public class Interfaceimpl implements DefaultImplInterface {
    @Override
    public String lambdaTest() {
        return "this is impl return!";
    }
//当接口写有默认实现时，实现类可以选择不重写此方法，不报错
}
