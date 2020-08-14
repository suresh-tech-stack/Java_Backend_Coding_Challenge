/**
 * 
 */
package com.orderitemservice.controller;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderitemservice.model.OrderItem;
import com.orderitemservice.service.OrderItemService;

/**
 * @author Suresh Ameda
 *
 */

@RestController
@RequestMapping("/Order")
public class OrderItemController {

	@Autowired
	OrderItemService orderItemService;

	@GetMapping("/getOrderItems")
	public List getAllOrderItems() {
		System.out.println("Received Request ....");
		return orderItemService.getAllorderItems();
	}
	@PostMapping("/orderItems")
    public void addBook(@RequestBody OrderItem orderItem) {
		System.out.println("Received Request ....");
		orderItemService.addOrderItem(orderItem);
    }

}
