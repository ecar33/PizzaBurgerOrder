package com.pizzaburger.pizza.crust;

/**
 * {@code ThinCrust} represents thin pizza crusts.
 */
public class ThinCrust extends PizzaCrust {
	@Override
	public String toString() {
		return "Thin Crust";
	}

	public Double getPrice() {
		return 3.70; 
	}

}
