package com.pizzaburger.pizza.sauce;
import com.pizzaburger.pizza.AbstractMenuItem;

/**
 * {@code PizzaSauce} represents all possible sauces that can go on a pizza
 */
public abstract class PizzaSauce extends AbstractMenuItem {
	public abstract String toString(); 
	
	public String toNiceString() {
		return "Sauce is: " + toString();
	}

	public Double getPrice() {
		return 0.30; // default price for sauce
	}
}
