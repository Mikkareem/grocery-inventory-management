package com.example.demo;

import com.example.demo.services.Database;
import com.example.demo.services.Grocery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return new ApplicationRunner();
	}
}

class ApplicationRunner implements CommandLineRunner {

	@Autowired
	private Database database;

	@Override
	public void run(String... args) throws Exception {
		Grocery grocery1 = new Grocery("Onion", 10);
		Grocery grocery2 = new Grocery("Apples", 20);
		Grocery grocery3 = new Grocery("Oranges", 30);
		Grocery grocery4 = new Grocery("Potatoes", 40);

		database.addGrocery(grocery1);
		database.addGrocery(grocery2);
		database.addGrocery(grocery3);
		database.addGrocery(grocery4);

		System.out.println("Groceries Added");
	}
}