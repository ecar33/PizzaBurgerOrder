package com.pizzaburger.pizza.topping;

/**
 * {@code SausageTopping} represents sausage-based topping meat
 */
public class SausageTopping extends MeatTopping {

	/**
	 * {@code SausageTopping} is twice as spicy as other meats, so spciness level needs to be doubled.
	 */
	public void adjustSpiciness() {
		spiciness = spiciness * 2;
	}
	
	public String toString() {
		return "Sausage Topping";
	}

	public Double getPrice() {
		return 1.75; 
	}

}

