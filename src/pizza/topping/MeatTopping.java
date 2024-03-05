package pizza.topping;

/**
 * {@code MeatTopping} represents all possible meat toppings that can go on a pizza
 */
public class MeatTopping extends PizzaTopping {
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
