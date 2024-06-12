package com.devdynamics.InventoryManagement.Service;

import org.springframework.stereotype.Service;

import com.devdynamics.InventoryManagement.model.Customer;
import com.devdynamics.InventoryManagement.model.Discount;
import com.devdynamics.InventoryManagement.model.Product;

import java.util.*;

@Service
public class InventoryService {
	final List<Product> inventory = new ArrayList<>();
	final List<Customer> customers = new ArrayList<>();
	final List<Discount> discount = new ArrayList<>();
	InventoryService()
	{
		Product p1 = new Product();
		p1.setProduct_id("cheese");
		p1.setQuantity(5);
		p1.setPrice(100);
		inventory.add(p1);
		
		Product p2 = new Product();
		p2.setProduct_id("butter");
		p2.setQuantity(1);
		p2.setPrice(50);
		inventory.add(p2);
		
		Customer c1 = new Customer();// new customer
		c1.setCustomer_id(1001);
		c1.setCartValue(0);
		c1.setCart(new HashMap<String,Integer>());
		customers.add(c1);
		
		Customer c2 = new Customer();
		c2.setCustomer_id(1002);
		c2.setCartValue(0);
		c2.setCart(new HashMap<String,Integer>());
		customers.add(c2);
		
		Discount d1 = new Discount();
		d1.setDiscount_percentage(5);
		d1.setMax_discount(40);
		d1.setDiscountID("5OFF");
		discount.add(d1);
		Discount d2 = new Discount();
		d2.setDiscount_percentage(20);
		d2.setMax_discount(20);
		d2.setDiscountID("20OFF");
		discount.add(d2);
	}
	public int discount(int cartValue,String discountID)
	{
		for(Discount d : discount )
		{
			if(d.getDiscountID().equals(discountID))
			{
				int per = d.getDiscount_percentage();
				int dis = cartValue*(per/100);
				if(dis>d.getMax_discount())
					return d.getMax_discount();
				else
					return dis;
			}
		}
		return 0;
	}
	public String addItem(String product_id,int quantity,int price)
	{
		Product prod = new Product();
		prod.setProduct_id(product_id);
		prod.setQuantity(quantity);
		prod.setPrice(price);
		inventory.add(prod);
		return "Item added";
	}
	
	public List<Product> allitems()
	{
		return inventory;
	}
	public List<Customer> allcustomers()
	{
		return customers;
	}
	public String remove(String product_id,Integer quantity)
	{
		for(Product prod : inventory)
		{
			if(prod.getProduct_id().equalsIgnoreCase(product_id))
			{
				Product p1 = prod;
				int quant = p1.getQuantity()-quantity;
				p1.setQuantity(quant);
				inventory.remove(prod);
				if(quant>0)
				{
					inventory.add(p1);
					return "item updated";
				}
				else
				return "Item successfully removed";
			}
		}
		return "Item not present in Inventory";
	}
	public Customer addItemtoCart(int customer_id,String product_id,int quantity)
	{
		Customer customer = new Customer();
		for(Customer c : customers)
		{
			if(c.getCustomer_id()==customer_id)
			{
				customer = c;
				break;
			}
		}
		int val=0;
		for(Product p : inventory)
		{
			if(p.getProduct_id().equalsIgnoreCase(product_id))
			{
				val = p.getPrice()*quantity;
			}
		}
		customer.setCartValue(customer.getCartValue()+val);
		HashMap<String,Integer> cart = customer.getCart();
		cart.put(product_id,quantity);
		customer.setCart(cart);
		return customer;
		
	}
}