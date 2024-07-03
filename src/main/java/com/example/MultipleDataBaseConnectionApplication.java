package com.example;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.orderEntity.Order1;
import com.example.orderRepository.OrderDao;
import com.example.productEntity.Product;
import com.example.productRepository.ProductDao;

@SpringBootApplication
public class MultipleDataBaseConnectionApplication implements CommandLineRunner {
	@Autowired
	ProductDao productDao;
	
	@Autowired
	OrderDao orderDao;

	public static void main(String[] args) {
		SpringApplication.run(MultipleDataBaseConnectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Product product = new Product(1, "MacBook", 300000);
		productDao.save(product);  // Oracle
		
		Order1 order = new Order1(1, "Lenovo", LocalDate.now());
		orderDao.save(order); // Postgres
	}

}
