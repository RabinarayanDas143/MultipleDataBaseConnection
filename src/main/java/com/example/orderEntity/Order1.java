package com.example.orderEntity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order1 {
	@Id
	private int orderId;
	private String orderNmae;
	private LocalDate dateorder;

	
	
	public Order1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order1(int orderId, String orderNmae, LocalDate localDate) {
		super();
		this.orderId = orderId;
		this.orderNmae = orderNmae;
		this.dateorder = localDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderNmae() {
		return orderNmae;
	}

	public void setOrderNmae(String orderNmae) {
		this.orderNmae = orderNmae;
	}

	public LocalDate getDate() {
		return dateorder;
	}

	public void setDate(LocalDate date) {
		this.dateorder = date;
	}

}
