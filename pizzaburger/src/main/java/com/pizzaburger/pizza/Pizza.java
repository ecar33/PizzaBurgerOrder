package com.pizzaburger.pizza;

import java.util.ArrayList;
import java.util.Collections;

import com.pizzaburger.pizza.crust.PizzaCrust;
import com.pizzaburger.pizza.sauce.PizzaSauce;
import com.pizzaburger.pizza.topping.PizzaTopping;

/**
 * {@code Pizza} represents a complete pizza composed of crust, sauce and
 * toppings.
 */
public class Pizza extends AbstractMenuItem {
	private PizzaCrust crust;
	private PizzaSauce sauce;
	private ArrayList<PizzaTopping> toppingList;
	private ArrayList<AbstractMenuItem> pizzaComponents;
	private boolean hasFourOrMoreToppings = false;

	public Pizza() {
		this.crust = null;
		this.sauce = null;
		this.toppingList = new ArrayList<PizzaTopping>();
		this.pizzaComponents = new ArrayList<AbstractMenuItem>();
	}

	public Pizza(PizzaCrust crust, PizzaSauce sauce) {
		this.crust = crust;
		this.sauce = sauce;
		this.toppingList = new ArrayList<PizzaTopping>();
		this.pizzaComponents = new ArrayList<AbstractMenuItem>();
	}

	public PizzaCrust getCrust() {
		return this.crust;
	}

	/**
	 * In addition to setting crust, setCrust also sticks the crust into the
	 * pizzaComponents list for future displays
	 * 
	 * @param crust the selected crust
	 */
	public void setCrust(PizzaCrust crust) {
		if (this.crust != null) {
			// Replace the existing crust in the pizzaComponents list
			int index = pizzaComponents.indexOf(this.crust);
			if (index != -1) {
				pizzaComponents.set(index, crust);
			}
		} else {
			// Add the crust if it's the first time setting it
			this.addComponent(crust);
		}
		this.crust = crust;
	}

	public PizzaSauce getSauce() {
		return this.sauce;
	}

	/**
	 * In addition to setting sauce, setSauce also sticks the sauce into the
	 * pizzaComponents list for future displays
	 * 
	 * @param crust the selected sauce
	 */

	public void setSauce(PizzaSauce sauce) {
		if (this.sauce != null) {
			// Replace the existing sauce in the pizzaComponents list
			int index = pizzaComponents.indexOf(this.sauce);
			if (index != -1) {
				pizzaComponents.set(index, sauce);
			}
		} else {
			// Add the sauce if it's the first time setting it
			this.addComponent(sauce);
		}
		this.sauce = sauce;
	}

	public ArrayList<PizzaTopping> getToppings() {
		return this.toppingList;
	}

	/**
	 * In addition to setting toppings, setTopping also appends the topping list
	 * into the pizzaComponents list for future displays
	 * 
	 * @param topping the selected toppings
	 */
	public void setTopping(ArrayList<PizzaTopping> toppings) {
		this.toppingList = toppings;
		this.getComponents().addAll(toppings);
	}

	/**
	 * Add one topping into the toppping list.
	 * In addtition, add topping to the pizzaComponents list
	 * 
	 * @param topping the selected topping
	 */
	public void addTopping(PizzaTopping topping) {
		if (!pizzaComponents.contains(topping)) {
			// Check if the pizza already has four or more toppings
			if (hasFourOrMoreToppings) {
				// Find the first topping added (the oldest) and replace it
				PizzaTopping firstTopping = toppingList.remove(0); // Remove the oldest topping
				pizzaComponents.remove(firstTopping); // Also remove it from the pizzaComponents list

				// Now add the new topping
				toppingList.add(topping); // Add the new topping to the end of the list
				pizzaComponents.add(topping);
			} else {
				toppingList.add(topping);
				hasFourOrMoreToppings = checkIfFourOrMoreToppings();
				pizzaComponents.add(topping);
			}
		}
	}

	public void resetToppings() {
		toppingList = new ArrayList<PizzaTopping>();
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
	 * Checks if the toppings count is greater than or equal to four.
	 * 
	 * @return true if the number of toppings is four or fewer, false otherwise.
	 */
	public boolean checkIfFourOrMoreToppings() {
		return this.toppingList.size() >= 4;
	}

	/**
	 * Sorts the pizza components before listing them.
	 * Note that sort is done in-place, this permanently changes the ordering in the
	 * list.
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
