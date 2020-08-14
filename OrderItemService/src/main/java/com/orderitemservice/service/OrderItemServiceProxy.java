package com.orderitemservice.service;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orderitemservice.model.OrderItem;

@FeignClient(name="OrderService" )
public interface OrderItemServiceProxy {

	@RequestMapping("/order")
	public Collection<OrderItem> getOrdersItems();
	
	@PutMapping("/order")
	public void saveOrder();
}