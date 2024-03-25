package com.pizzaburger.burger.topping;
import com.pizzaburger.menuitem.AbstractMenuItem;

/**
 * {@code BurgerTopping} represents all possible toppings that can go on a pizza
 */
public abstract class BurgerTopping extends AbstractMenuItem {
	public abstract String toString(); 
	
	public String toNiceString() {
		return "Topping is: " + toString();
	}

	public Double getPrice() {
		return 0.50; // default price for topping
	}
}
