package com.pizzaburger.burger.sauce;

/**
 * {@code SpicyMayoSauce} represents our in house twist on mayo
 */
public class SpicyMayoSauce extends BurgerSauce {
	@Override
	public String toString() {
		return "Spicy Mayo Sauce";
	}

	@Override
	public Double getPrice() {
		return .80; 
	}

}
