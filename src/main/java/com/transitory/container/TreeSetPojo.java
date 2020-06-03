package com.transitory.container;

import org.jetbrains.annotations.NotNull;

/**
 * @program: basicDemo
 * @description: treeset使用的测试类
 * @author: 无能狂怒
 * @create: 2020-04-20 22:42
 **/
public class TreeSetPojo implements Comparable {


    private String name;
    private Integer age;

    public TreeSetPojo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public TreeSetPojo() {
    }

    @Override
    public String toString() {
        return "TreeSetPojo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeSetPojo that = (TreeSetPojo) o;

        if (!name.equals(that.name)) return false;
        return age.equals(that.age);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        TreeSetPojo that = (TreeSetPojo) o;
        if (this.getAge()>that.getAge()){
            return 1;
        }else  if(this.getAge()<that.getAge()){
            return -1;
        }else  {
            return 0;
        }
    }
}
