package com.pizzaburger.burger.topping;

/**
 * {@code MeatTopping} represents all possible meat toppings that can go on a burger
 */
public class MeatTopping extends BurgerTopping {
	/**
	 * Meat toppings can vary in spiciness from 1-10.
	 */
	protected Integer spiciness;

	public MeatTopping() {
		this.spiciness = 0;
	}
	
	public MeatTopping(Integer spiciness) {
		this.spiciness = spiciness;
	}

	public String toString() {
		return "Meat Topping";
	}
	
	public Integer getSpiciness() {
		return this.spiciness;
	}
	
	public void setSpiciness(Integer spiciness) {
		this.spiciness = spiciness;
	}
	
	/**
	 * For meat toppings we also want to output the spiciness.
	 */
	@Override
	public String toNiceString() {
		return super.toNiceString() + " spiciness: " + spiciness;
	}

	@Override
	public Double getPrice() {
		return 0.60; 
	}

}
