package com.pizzaburger.burger.topping;

/**
 * {@code CheddarTopping} represents cheddar cheese
 */
public class CheddarTopping extends CheeseTopping {
	public String toString() {
		return "Cheddar Topping";
	}

	@Override
	public Double getPrice() {
		return .60; 
	}

}
