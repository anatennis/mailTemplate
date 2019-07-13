package com.example.demo.entity;

import lombok.Data;

@Data
public class Item {
    private String name;
    private int count;
    private int price;

    public Item(String name, int count, int price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }
}
