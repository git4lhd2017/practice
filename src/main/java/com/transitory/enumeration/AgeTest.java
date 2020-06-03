package com.transitory.enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum AgeTest {

    SHAONIAN("少年",new int[]{13,14,15,16,17,18,19,20}),QINGNIAN("青年",new int[]{21,22,23,24,25,26,27,28,29,30}),YOUNIAN("幼年",new int[]{1,2,3,4,5,6,7,8,9,10,11,12});

    private String desc;
    private int[] age;

    AgeTest(String desc,int[] age){
        this.desc = desc;
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int[] getAge() {
        return age;
    }

    public void setAge(int[] age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "AgeTest{" +
                "desc='" + desc + '\'' +
                ", age=" + Arrays.toString(age) +
                '}';
    }
}
