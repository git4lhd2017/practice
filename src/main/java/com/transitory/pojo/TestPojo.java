package com.transitory.pojo;

import java.io.Serializable;

/**
 * @program: basicDemo
 * @description: 测试用实体类
 * @author: 无能狂怒
 * @create: 2020-02-22 18:33
 **/
public class TestPojo implements Serializable {

    private String name;

    private int age;

    private String gender;


    public TestPojo() {
    }

    public TestPojo(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "TestPojo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestPojo testPojo = (TestPojo) o;

        if (age != testPojo.age) return false;
        if (!name.equals(testPojo.name)) return false;
        return gender.equals(testPojo.gender);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + gender.hashCode();
        return result;
    }
}
