package com.orderitemservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderitemservice.model.OrderItem;
import com.orderitemservice.repo.OrderItemRepo;

/**
 * 
 * @author Suresh Ameda
 *
 */

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepo orderItemRepository;

	@SuppressWarnings("unchecked")
	public List<Object> getAllorderItems() {
		List<Object> orderItem = new ArrayList<>();
		orderItemRepository.findAll().forEach(orderItem::add);
		return orderItem;
	}

	@SuppressWarnings("unchecked")
	public void addOrderItem(OrderItem orderItem) {
		orderItemRepository.save(orderItem);
	}

}