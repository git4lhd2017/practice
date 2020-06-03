package com.thinking_in_java.genericity;

public enum CustomColor {
    RED("this is red!"), GREED("this is greed!"), YELLOW("this is yellow!"),
    BLUE("this is blue"), PINK("this is pink!"), WHITE("this is white!");


    private String description;

    CustomColor(String s) {
        this.description = s;
    }

    @Override
    public String toString() {
        return "CustomColor:"+this.name()+",序号："+this.ordinal()+"，描述：{" +
                "description='" + description + '\'' +
                '}';
    }
}
