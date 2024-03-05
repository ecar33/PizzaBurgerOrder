package pizza;
import java.util.ArrayList;
import java.util.Collections;

import pizza.crust.PizzaCrust;
import pizza.sauce.PizzaSauce;
import pizza.topping.PizzaTopping;

/**
 * {@code Pizza} represents a complete pizza composed of crust, sauce and toppings.
 */
public class Pizza extends AbstractMenuItem {
	private PizzaCrust crust;
	private PizzaSauce sauce;
	private ArrayList<PizzaTopping> toppingList;
	private ArrayList<AbstractMenuItem> pizzaComponents;
	
	public Pizza() {
		this.crust = null;
		this.sauce = null;
		this.toppingList = new ArrayList<PizzaTopping>();
		this.pizzaComponents = new ArrayList<AbstractMenuItem>();
	}

	public PizzaCrust getCrust() {
		return this.crust;
	}

	/**
	 * In addition to setting crust, setCrust also sticks the crust into the pizzaComponents list for future displays
	 * @param crust the selected crust
	 */
	public void setCrust(PizzaCrust crust) {
		this.crust = crust;
		this.addComponent(crust);
	}

	public PizzaSauce getSauce() {
		return this.sauce;
	}

	/**
	 * In addition to setting sauce, setSauce also sticks the sauce into the pizzaComponents list for future displays
	 * @param crust the selected sauce
	 */
	public void setSauce(PizzaSauce sauce) {
		this.sauce = sauce;
		this.addComponent(sauce);
	}

	public ArrayList<PizzaTopping> getTopping() {
		return this.toppingList;
	}

	/**
	 * In addition to setting toppings, setTopping also appends the topping list into the pizzaComponents list for future displays
	 * @param topping the selected toppings
	 */
	public void setTopping(ArrayList<PizzaTopping> toppings) {
		this.toppingList = toppings;
		this.getComponents().addAll(toppings);
	}

	/**
	 * Add one topping into the toppping list.
	 * In addtition, add topping to the pizzaComponents list
	 * @param topping the selected topping
	 */
	public void addTopping(PizzaTopping topping) {
		this.toppingList.add(topping);
		this.addComponent(topping);
	}

	public ArrayList<AbstractMenuItem> getComponents() {
		return this.pizzaComponents;
	}

	public void addComponent(AbstractMenuItem item) {
		this.pizzaComponents.add(item);
	}
	
	public String toNiceString() {
		return "Pizza is: " + toString();
	}
	
	/**
	 * @returns the pizza string as concatenation of all its component strings
	 */
	public String toString() {
		String pizzaDesc = crust + ", " + sauce;
		for (PizzaTopping t : toppingList) {
			pizzaDesc += ", " + t.toString();
		}
		return pizzaDesc;
	}
	
	/**
	 * Lists all pizza components
	 */
	public void display() {
		for (MenuItem m : this.pizzaComponents) {
			System.out.printf("%s $%.2f\n", m.toNiceString(), m.getPrice());
		}
	}
	
	/**
	 * Sorts the pizza components before listing them.
	 * Note that sort is done in-place, this permanently changes the ordering in the list.
	 */
	public void displaySorted() {
		Collections.sort(this.pizzaComponents);
		display();
	}
	
	/**
	 * Compute pizza price as the sum of its parts.
	 */
	public Double getPrice() {
		Double total = 0.0;
		for (MenuItem m : pizzaComponents) {
			total += m.getPrice();
		}
		return total;
	}
}
