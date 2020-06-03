package com.animal.person;

import java.io.Serializable;

/**
 * @program: basicDemo
 * @description: 女人
 * @author: 无能狂怒
 * @create: 2020-05-28 14:47
 **/
public class Woman implements Serializable {


    private static final long serialVersionUID = 2996549471091028431L;

    private int age = 0;//年龄
    private float height = 0.0f;//身高，单位米（metres）
    private float weight = 0.0f;//体重,单位（kilogram）
    private String profession = "no";//职业


    public Woman() {
    }

    public Woman(int age, float height, float weight, String profession) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.profession = profession;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Woman woman = (Woman) o;

        if (age != woman.age) return false;
        if (Float.compare(woman.height, height) != 0) return false;
        if (Float.compare(woman.weight, weight) != 0) return false;
        return profession != null ? profession.equals(woman.profession) : woman.profession == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (height != +0.0f ? Float.floatToIntBits(height) : 0);
        result = 31 * result + (weight != +0.0f ? Float.floatToIntBits(weight) : 0);
        result = 31 * result + (profession != null ? profession.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Woman{" +
                "age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", profession='" + profession + '\'' +
                '}';
    }

    public void doJob(){
        System.out.println(profession);
    }

    public void doJob(String job){
        this.profession = job;
        this.doJob();
    }

}


