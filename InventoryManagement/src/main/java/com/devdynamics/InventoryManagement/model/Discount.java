package com.devdynamics.InventoryManagement.model;

public class Discount {
	private String discountID;
	private int Discount_percentage;
	private int max_discount;
	public Discount()
	{}
	public int getDiscount_percentage() {
		return Discount_percentage;
	}
	public void setDiscount_percentage(int discount_percentage) {
		Discount_percentage = discount_percentage;
	}
	public int getMax_discount() {
		return max_discount;
	}
	public void setMax_discount(int max_discount) {
		this.max_discount = max_discount;
	}
	public String getDiscountID() {
		return discountID;
	}
	public void setDiscountID(String discountID) {
		this.discountID = discountID;
	}
	
}
