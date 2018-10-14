package com.zj.demo.ws.entity;

import java.io.Serializable;

/**
 * Creator: zhuji
 * Date: 2018/10/14
 * Time: 2:43
 * Description:
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 1382636539173987801L;

    private String name;

    private int age;

    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
