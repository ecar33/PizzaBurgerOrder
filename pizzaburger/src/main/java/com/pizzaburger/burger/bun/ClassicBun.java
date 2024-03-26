package com.pizzaburger.burger.bun;

/**
 * {@code ClassicBun} represents classic burger buns.
 */
public class ClassicBun extends BurgerBun {
	@Override
	public String toString() {
		return "Classic Bun";
	}

	@Override
	public Double getPrice() {
		return .80; 
	}

}
