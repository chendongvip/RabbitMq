package com.example.chendong.rabbitmq01.dto;

import java.io.Serializable;

/**
 * 网络上传输的对象 实现序列化
 */
public class User implements Serializable {

    private Integer id;

    private String userName;

    private String name;

    public User(){

    }

    public User(Integer id, String userName, String name) {
        this.id = id;
        this.userName = userName;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
