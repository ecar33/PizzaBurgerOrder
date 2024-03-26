package com.pizzaburger.burger.bun;

/**
 * {@code PretzelBun} represents pretzel burger buns.
 */
public class PretzelBun extends BurgerBun {
	@Override
	public String toString() {
		return "Pretzel Bun";
	}

	@Override
	public Double getPrice() {
		return 2.25; 
	}

}
