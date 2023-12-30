package com.example.demo.services;

import java.util.UUID;

public class Grocery {
    private final String name;
    private Integer count;
    private final String id = UUID.randomUUID().toString();

    public Grocery(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }

    public String getId() {
        return id;
    }

    public void addMoreCount(Integer count) {
        this.count += count;
    }
}
