package com.orderinfoservice.service;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orderinfoservice.model.OrderData;

@FeignClient(name="OrderService" )
public interface OrderItemServiceProxy {

	@RequestMapping("/order")
	public Collection<OrderData> getOrdersItems();
	
	@PutMapping("/order")
	public void saveOrderItem();
}