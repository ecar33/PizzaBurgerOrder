package com.pizzaburger.burger.topping;

public class MeatTopping extends BurgerTopping {
	/**
	 * The spiciness level of the meat topping, ranging from 1 to 10.
	 */
	protected Integer spiciness;

	/**
	 * Constructs a {@code MeatTopping} with default spiciness.
	 */
	public MeatTopping() {
			this.spiciness = 0; // Assuming 0 is intended to represent 'no spiciness' or 'default'
	}
	
	/**
	 * Constructs a {@code MeatTopping} with specified spiciness.
	 * 
	 * @param spiciness the spiciness level of the meat topping
	 */
	public MeatTopping(Integer spiciness) {
			this.spiciness = spiciness;
	}

	/**
	 * Returns a simple string representation of a meat topping.
	 * 
	 * @return A string describing the meat topping.
	 */
	@Override
	public String toString() {
			return "Meat Topping";
	}
	
	/**
	 * Returns the spiciness level of the meat topping.
	 * 
	 * @return The spiciness level.
	 */
	public Integer getSpiciness() {
			return this.spiciness;
	}
	
	/**
	 * Sets the spiciness level of the meat topping.
	 * 
	 * @param spiciness The spiciness level to set.
	 */
	public void setSpiciness(Integer spiciness) {
			this.spiciness = spiciness;
	}
	
	/**
	 * Returns a nicely formatted string representing the meat topping and its spiciness.
	 * 
	 * @return A descriptive string of the meat topping including its spiciness level.
	 */
	@Override
	public String toNiceString() {
			return super.toNiceString() + " spiciness: " + spiciness;
	}

	/**
	 * Returns the price of the meat topping.
	 * 
	 * @return The price of the topping.
	 */
	@Override
	public Double getPrice() {
			return 0.80; // Assuming a fixed price for the example
	}
}