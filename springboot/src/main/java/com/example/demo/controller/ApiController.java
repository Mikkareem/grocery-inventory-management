package com.example.demo.controller;

import com.example.demo.services.Database;
import com.example.demo.services.Grocery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groceries")
@CrossOrigin(origins = "http://localhost:5173/")
public class ApiController {

    @Autowired
    private Database database;

    @GetMapping
    public List<Grocery> getAllGroceries() {
        return database.getAllGroceries();
    }

    @PostMapping
    public ResponseEntity<Boolean> addGrocery(@RequestBody Grocery grocery) {
        database.addGrocery(grocery);
        return ResponseEntity.ok(true);
    }
}
