package com.devdynamics.InventoryManagement.model;

import java.util.*;
public class Customer {
	private int customer_id;
	private HashMap<String,Integer> cart;//product_id,quantity
	private int cartValue;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public HashMap<String, Integer> getCart() {
		return cart;
	}
	public void setCart(HashMap<String, Integer> cart) {
		this.cart = cart;
	}
	public int getCartValue() {
		return cartValue;
	}
	public void setCartValue(int cartValue) {
		this.cartValue = cartValue;
	}
}
