package com.pizzaburger.burger.topping;

/**
 * {@code PattyTopping} represents a standard hamburger patty
 */
public class PattyTopping extends MeatTopping {

	public String toString() {
		return "Patty Topping";
	}

	@Override
	public Double getPrice() {
		return 1.0; 
	}

}

