package com.pizzaburger.burger.sauce;
import com.pizzaburger.menuitem.AbstractMenuItem;

/**
 * {@code BurgerSauce} represents all possible sauces that can go on a burger
 */
public abstract class BurgerSauce extends AbstractMenuItem {
	public abstract String toString(); 
	
	public String toNiceString() {
		return "Sauce is: " + toString();
	}

	public Double getPrice() {
		return 0.30; // default price for sauce
	}
}
