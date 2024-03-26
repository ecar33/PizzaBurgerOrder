package com.pizzaburger.burger.topping;

/**
 * {@code PepperjackTopping} represents pepperjack cheese
 */
public class PepperjackTopping extends CheeseTopping {
	public String toString() {
		return "Pepperjack Topping";
	}

	@Override
	public Double getPrice() {
		return .60;
	}

}
