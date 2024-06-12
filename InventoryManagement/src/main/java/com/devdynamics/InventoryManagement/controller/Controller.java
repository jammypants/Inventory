package com.devdynamics.InventoryManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devdynamics.InventoryManagement.Service.InventoryService;
import com.devdynamics.InventoryManagement.model.Customer;
import com.devdynamics.InventoryManagement.model.Product;

@RestController
@RequestMapping("/assignment")
public class Controller {
	@Autowired
	private InventoryService service;
	
	@PostMapping("/add/{product_id}/{quantity}/{price}")
	public String addItem(@PathVariable String product_id,@PathVariable int quantity,@PathVariable int price)
	{
		return service.addItem(product_id,quantity,price);
	}
	@GetMapping("/allitems")
	public List<Product> getAll()
	{
		return service.allitems();
	}
	@GetMapping("/remove/{product_id}/{quantity}")
	public String remove(@PathVariable String product_id,@PathVariable int quantity)
	{
		return service.remove(product_id,quantity);
	}
	@GetMapping("/customers")
	public List<Customer> all_customers()
	{
		return service.allcustomers();
	}
	@GetMapping("/addcart/{customer_id}/{product_id}/{quantity}")
	public Customer addtocart(@PathVariable int customer_id,@PathVariable String product_id,@PathVariable int quantity)
	{
		return service.addItemtoCart(customer_id, product_id, quantity);
	}
	@GetMapping("/discount/{cart_value}/{discount_id}")
	public int Discount(@PathVariable int cart_value,@PathVariable String discount_id)
	{
		return service.discount(cart_value, discount_id);
	}
}
