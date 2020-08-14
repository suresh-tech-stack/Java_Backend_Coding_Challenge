package com.orderinfoservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderinfoservice.model.OrderData;

/**
 * 
 * @author Suresh Ameda
 *
 */
@RestController
@RequestMapping("/order")
public class OrderInfoController {

	@Autowired
	Environment env;

	@GetMapping("/info")
	public String info() {
		String port = env.getProperty("local.server.port");
		return "call Server " + port;
	}

	@GetMapping("/getOrderInfo")
	public ResponseEntity<List<OrderData>> getAllProducts() {
		System.out.println("In ProductService:-> Controller ");
		List<OrderData> orderDataList = new ArrayList<OrderData>();
		OrderData products = new OrderData();
		products.setCustomerName("Suresh");
		products.setOrderDate("03/08/2020 19:05:00");
		products.setShippingAddress("Hyderabad");
		products.setOrderItems(orderDataList);
		products.setTotalPrice(500.0);
		orderDataList.add(products);
		products = new OrderData();
		products.setCustomerName("HCL");
		products.setOrderDate("03/08/2020 19:05:00");
		products.setShippingAddress("HitecCity");
		products.setOrderItems(orderDataList);
		products.setTotalPrice(1500.0);
		orderDataList.add(products);
		return new ResponseEntity<List<OrderData>>(orderDataList, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/createOrder")
	public ResponseEntity<OrderData> saveOrder(@RequestBody OrderData prodEntity) {

		System.out.println("Enter Product Controller....>");

		// Here we have to write the logic like ,..we have to get the OrderItems Data
		// from another service and we have to save the Order

		return new ResponseEntity<OrderData>(prodEntity, new HttpHeaders(), HttpStatus.OK);
	}

}
