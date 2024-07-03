package com.example.orderRepository;

import org.springframework.data.repository.CrudRepository;

import com.example.orderEntity.Order1;

public interface OrderDao extends CrudRepository<Order1, Integer>{

}
