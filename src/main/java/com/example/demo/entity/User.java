package com.example.demo.entity;

import lombok.Data;

@Data
public class User {
    private String name;
    private boolean registred;
    private int point;

    public User(String name, boolean registred, int point) {
        this.name = name;
        this.registred = registred;
        this.point = point;
    }
}
