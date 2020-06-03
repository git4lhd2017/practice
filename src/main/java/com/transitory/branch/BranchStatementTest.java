package com.transitory.branch;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-test.xml")
public class BranchStatementTest {


    /**验证：执行不到的false-for语句会编译报错
     *
     */

    @Test
    public void one(){


        int i = 1;
        //报错，编译错误
//        for(;false;){
//            System.out.println("hello,one");
//        }

        for(;true;){
            System.out.println("for print true");
            i++;
            if(i==10){
                System.out.println("死循环！");
                break;
            }
        }
    }




    /**如果有返回值的方法试用了分支函数，那么在任何一个分支内都要进行值的返回，不管会不会被执行到，否则报错
     *
     *
     * @return
     */
    public String two (){
        boolean flag = true;
        //就算判定值显式的定为true或false也不行
        if(flag){
            return "happy";
        }
        else{
//            else也要返回
            return "sad";
        }
        //如果没有else，外面必须要加返回语句，考虑全面
//        return "me too";
    }



    @Test
    public void test_switch_char(){
        char a = 'n';
        switch (a){
            case 'n':
                System.out.println("这个值是N");
                break;
            case 't':
                System.out.println("这个值是T");
                break;
            default:
                System.out.println("拦截不到char值");
                break;
        }
    }



    /**
    * @Description: 测试String类型的switch语句
    * @Param: []
    * @return: void
    * @Author: 无能狂怒
    * @Date: 2020/3/4
    */
    @Test
    public void test_switch_string(){
        //switch只能接收char，int，short，byte以及他们的包装类和enum以及String
        String a = "GG";
        switch (a){
            case "GG":
                System.out.println("游戏结束了！");
                break;
            case "HELLO":
                System.out.println("你们好啊！");
                break;
            default:
                System.out.println("拦截不到String值！");
                break;
        }
    }


}
