package com.thinking_in_java.inner_class.cover;

/**
 * @program: basicDemo
 * @description: 继承覆盖内部类问题,内部类在外部类被继承的时候并不会被自动继承，不过可以显式的被继承，
 * @author: 无能狂怒
 * @create: 2020-03-24 21:24
 **/
class Egg {

    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk()");
        }

        public void f() {
            System.out.println("Egg.Yolk.f()");
        }
    }

    private Yolk MyYolk = new Yolk();

    public Egg() {
        System.out.println("New Egg()");
    }

    public void insertYolk(Yolk yy) {
        this.MyYolk = yy;
    }

    public void g() {
        MyYolk.f();
    }

    ;

}
public class BigEgg extends Egg{

        public class Yolk extends Egg.Yolk{
            public Yolk(){
                System.out.println("BigEgg.Yolk()");
            }
            public void f(){
                System.out.println("BigRgg.Yolk.f()");
            }
        }
        public BigEgg(){
            insertYolk(new Yolk());
        }

        public static void main(String[] args) {
            Egg egg = new BigEgg();
            egg.g();
            BigEgg bigEgg = (BigEgg) egg;


            //测试方法，打印BigEgg的内部类Yolk的父类名称
            Yolk yolk = bigEgg.new Yolk();
            System.out.println(yolk.getClass().getSuperclass().getName());
        }


}


