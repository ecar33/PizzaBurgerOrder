package com.pizzaburger.burger.topping;

/**
 * {@code CheeseTopping} represents all possible cheese toppings that can go on a burger
 */
public class CheeseTopping extends BurgerTopping {
	@Override
	public String toString() {
		return "Cheese Topping";
	}

	@Override
	public Double getPrice() {
		return 0.50; 
	}
}
