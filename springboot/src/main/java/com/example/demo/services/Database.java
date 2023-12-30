package com.example.demo.services;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class Database {
    private final List<Grocery> groceryList;

    Database() {
        groceryList = new LinkedList<>();
    }

    public void addGrocery(Grocery g) {
        groceryList.add(g);
    }

    public void addMoreGroceryCount(String id, int count) {
        Optional<Grocery> desiredGrocery = groceryList.stream().filter(g -> g.getId().equals(id)).findFirst();
        if(desiredGrocery.isPresent()) {
            Grocery grocery = desiredGrocery.get();
            grocery.addMoreCount(count);
        }
    }

    public List<Grocery> getAllGroceries() {
        return groceryList;
    }
}
