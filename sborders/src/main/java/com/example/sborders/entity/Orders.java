package com.example.sborders.entity;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Orders {
    @Id
    private Long id;
    private LocalDate orderDate;
    private String shipMode;
    private String customerId;
    private Double sales;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getShipMode() {
		return shipMode;
	}
	public void setShipMode(String shipMode) {
		this.shipMode = shipMode;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public double getSales() {
		return sales;
	}
	public void setSales(double sales) {
		this.sales = sales;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderDate=" + orderDate + ", shipMode=" + shipMode + ", customerId=" + customerId
				+ ", sales=" + sales + "]";
	}
    
    
}