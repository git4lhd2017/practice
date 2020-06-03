package com.animal.pets;

import java.io.Serializable;

/**
 * @program: basicDemo
 * @description: 猫
 * @author: 无能狂怒
 * @create: 2020-05-28 15:26
 **/
public class Cats implements Serializable {

    private static final long serialVersionUID = -1550431680759966836L;

    private static int age = 0;//年龄
    private static String color = "no";//花色
    private static String cry = "喵喵喵";//叫声
    private static String name = "no";//名字

    public static String test = "this is test of getFields's method!";

    public Cats() {
    }

    public Cats( int age, String color, String cry, String name) {
        this.age = age;
        this.color = color;
        this.cry = cry;
        this.name = name;
    }


    public void doCry(){
        System.out.println(this.cry);
    }

    public void doCry(String newCry){
        System.out.println(newCry);
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

        Cats cats = (Cats) o;

        if (age != cats.age) return false;
        if (!color.equals(cats.color)) return false;
        if (!cry.equals(cats.cry)) return false;
        return name.equals(cats.name);
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
        return "Cats{" +
                "age=" + age +
                ", color='" + color + '\'' +
                ", cry='" + cry + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
