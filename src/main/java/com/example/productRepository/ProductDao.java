package com.example.productRepository;

import org.springframework.data.repository.CrudRepository;

import com.example.productEntity.Product;

public interface ProductDao extends CrudRepository<Product,Integer> {

}
