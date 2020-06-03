package com.animal.pets;

import java.io.Serializable;

/**
 * @program: basicDemo
 * @description: 狗
 * @author: 无能狂怒
 * @create: 2020-05-28 15:26
 **/
public class Dogs implements Serializable {

    private static final long serialVersionUID = -6016940127156335940L;
    private int age = 0;//年龄
    private String color = "no";//花色
    private String cry = "汪汪汪";//叫声
    private String name = "no";//名字




    /** 
    * @Description: 有参构造函数
    * @Param: [age, color, cry, name] 
    * @return:  
    * @Author: 无能狂怒 
    * @Date: 2020/5/28 
    */
    public Dogs(int age, String color, String cry, String name) {
        this.age = age;
        this.color = color;
        this.cry = cry;
        this.name = name;
    }


    public Dogs() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCry() {
        return cry;
    }

    public void setCry(String cry) {
        this.cry = cry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dogs dogs = (Dogs) o;

        if (age != dogs.age) return false;
        if (!color.equals(dogs.color)) return false;
        if (!cry.equals(dogs.cry)) return false;
        return name.equals(dogs.name);
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + color.hashCode();
        result = 31 * result + cry.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Dogs{" +
                "age=" + age +
                ", color='" + color + '\'' +
                ", cry='" + cry + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


    public void jump(){
        System.out.println("狗狗跳了一下！");
    }

    public void jump(int i){
        System.out.println("狗狗跳了"+i+"米！");
    }

}
