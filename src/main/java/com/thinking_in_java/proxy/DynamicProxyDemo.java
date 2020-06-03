package com.thinking_in_java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @program: basicDemo
 * @description: 动态代理演示
 * @author: 无能狂怒
 * @create: 2020-05-29 14:06
 **/
public class DynamicProxyDemo {
    public static void consumer(BasicClass bc){
        bc.doSomething();
        String things = "play Football!";
        bc.doSomething(things);
    }

    public static void main(String[] args) {
        RealObject ro = new RealObject();
        consumer(ro);
        BasicClass bc = (BasicClass) Proxy.newProxyInstance(BasicClass.class.getClassLoader(),new Class[]{BasicClass.class},
                new DynamicProxy(ro));
        consumer(bc);
    }

}
class DynamicProxy implements InvocationHandler {

    private Object proxied;
    public DynamicProxy(Object proxied){
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy:"+proxy.getClass().getSimpleName()+"'s method："+method.getName()+", args:" + Arrays.toString(args));
        return method.invoke(proxied,args);
    }
}