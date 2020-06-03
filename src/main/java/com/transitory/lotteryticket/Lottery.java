package com.transitory.lotteryticket;

import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Set;

/**
 * @program: basicDemo
 * @description: 彩票实体类
 * @author: 无能狂怒
 * @create: 2020-04-20 22:00
 **/
public class Lottery implements Serializable {


    private static SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日-HH:mm:ss");
    private static SimpleDateFormat sformat = new SimpleDateFormat("yyyyMMddHHmmss");
    private Set<Integer> redNum;
    private Integer blueNum;
    private String date;
    private String sname;

    public Lottery() {
    }

    public Lottery(Set<Integer> redNum, Integer blueNum) {
        this.redNum = redNum;
        this.blueNum = blueNum;
        this.date = format.format(new Date().getTime());
        this.sname = sformat.format(new Date().getTime());
    }

    public Set<Integer> getRedNum() {
        return redNum;
    }

    public void setRedNum(Set<Integer> redNum) {
        this.redNum = redNum;
    }

    public Integer getBlueNum() {
        return blueNum;
    }

    public void setBlueNum(Integer blueNum) {
        this.blueNum = blueNum;
    }

    public String getDate(){return date;}
    public String getSname(){return sname;}

    @Override
    public String toString() {
        return "红："+ redNum +
                ",\n 蓝：" + blueNum +
                ",\n 日期：" + date;
    }
}
