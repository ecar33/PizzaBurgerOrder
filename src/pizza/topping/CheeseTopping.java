package pizza.topping;

/**
 * {@code CheeseTopping} represents all possible cheese toppings that can go on a pizza
 */
public class CheeseTopping extends PizzaTopping {
	@Override
	public String toString() {
		return "Cheese Topping";
	}

	@Override
	public Double getPrice() {
		return 0.20; 
	}
}
