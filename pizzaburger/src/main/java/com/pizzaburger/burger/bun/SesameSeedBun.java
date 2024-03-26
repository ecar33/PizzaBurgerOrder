package com.pizzaburger.burger.bun;

/**
 * {@code SesameSeedBun} represents sesame seed burger buns.
 */
public class SesameSeedBun extends BurgerBun {
	@Override
	public String toString() {
		return "Sesame Seed Bun";
	}

	@Override
	public Double getPrice() {
		return .80; 
	}

}
