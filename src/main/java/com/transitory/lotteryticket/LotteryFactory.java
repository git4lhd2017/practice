package com.transitory.lotteryticket;

import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;
import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: basicDemo
 * @description: 随机双色球生成工厂
 * @author: 无能狂怒
 * @create: 2020-04-20 21:58
 **/
public class LotteryFactory {

    private Random RandomNum = new Random();
    private String path = "F://lotterys";
    private Scanner sc = new Scanner(System.in);
    private int state = 0;//0:no operation;1:generate and serialize;2:deserialize and see;


    public Lottery getLottery(){
        Set<Integer> redNum = new TreeSet<>();
        while (redNum.size()<6){
            redNum.add(RandomNum.nextInt(32)+1);
        }
        Integer blueNum = RandomNum.nextInt(15)+1;

        return new Lottery(redNum,blueNum);

    }


    public static void main(String[] args) {
        while (true){
        LotteryFactory factory = new LotteryFactory();
            System.out.println("----------------------------------------");
        System.out.println("请输入你想要进行的操作（输入菜单序号）：");
        System.out.println("1：generate and serialize！");
        System.out.println("2：deserialize and see！");
        System.out.println("其他为不操作！");
            System.out.println("----------------------------------------");




        int num = factory.sc.nextInt();

        switch (num){
            case 1:
                Lottery lottery = factory.getLottery();
                System.out.println("------------------------------------------------------------");
                System.out.println(lottery);
                System.out.println("------------------------------------------------------------");
                factory.serialize(lottery,lottery.getSname());
                break;
            case 2:
                factory.deserialize();
                break;
            default:
                System.out.println("菜单指令错误，程序已退出！");
                System.exit(0);
                break;


        }



    }
    }
    public void running(){

        System.out.println("请输入你要彩票的个数：");
        int num = this.sc.nextInt();
        Lottery[] lotteries = new Lottery[num];


    }


    public void serialize(Object o,String name){

        ObjectOutputStream oos = null;
        try {
        File file = new File(path+"//"+name+".txt");
        file.createNewFile();
            oos = new ObjectOutputStream(new FileOutputStream(file));

            oos.writeObject(o);
        } catch (IOException e) {

            System.out.println("文件序列化出错");

        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                System.out.println("close stream exception!");
            }
        }

    }

    public void deserialize(){


        Scanner sc = new Scanner(System.in);

        File files = null;
        ObjectInputStream ois =null;

        try {
            files = new File(path);
            String[] list = files.list();
            System.out.println("----------------------------------------");
            System.out.println("请输入要查看的文件序号！");

            for (int i =0;i<list.length;i++){
                System.out.println(i+"  "+list[i]);
            }

            System.out.println("----------------------------------------");

            int num = sc.nextInt();

            if(num < 0 || num >=list.length){
                System.out.println("num is illegal");
                return;
            }

            ois = new ObjectInputStream( new FileInputStream(path +"//"+ list[num]));

            Lottery l = (Lottery) ois.readObject();
            System.out.println("----------------------------------------");
            System.out.println(l);
            System.out.println("----------------------------------------");
            return ;

        } catch (ClassNotFoundException e){
            System.out.println("class not found exception！");
            return;
        } catch (FileNotFoundException e) {
            System.out.println("file not found exception!");
            return;
        } catch (IOException e){
            System.out.println("open stream exception!！");
            e.printStackTrace();
            return;
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                System.out.println("close stream error!");
            }
        }

    }


}
