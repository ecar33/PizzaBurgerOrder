package com.pizzaburger.pizza.topping;

/**
 * {@code VeggieTopping} represents all possible veggie toppings that can go on a pizza
 */
public class VeggieTopping extends PizzaTopping {
	@Override
	public String toString() {
		return "Veggie Topping";
	}


	public Double getPrice() {
		return .90 ; // default price for vegetable toppings
	}

}
