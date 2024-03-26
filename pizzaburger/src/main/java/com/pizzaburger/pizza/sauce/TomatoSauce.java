package com.pizzaburger.pizza.sauce;

/**
 * {@code TomatoSauce} represents all tomato-based sauces
 */
public class TomatoSauce extends PizzaSauce {
	@Override
	public String toString() {
		return "Tomato Sauce";
	}

	public Double getPrice() {
		return 1.75; 
	}
}
