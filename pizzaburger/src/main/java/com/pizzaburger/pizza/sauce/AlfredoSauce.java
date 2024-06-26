package com.pizzaburger.pizza.sauce;

/**
 * {@code AlfredoSauce} represents a special kind of heavy cream-based sauce
 */
public class AlfredoSauce extends PizzaSauce {
	@Override
	public String toString() {
		return "Alfredo Sauce";
	}

	public Double getPrice() {
		return 2.50; 
	}

}
