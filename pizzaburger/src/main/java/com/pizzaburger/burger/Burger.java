package com.pizzaburger.burger;

import java.util.ArrayList;
import java.util.Collections;

import com.pizzaburger.menuitem.AbstractMenuItem;
import com.pizzaburger.menuitem.MenuItem;
import com.pizzaburger.pizza.topping.PizzaTopping;
import com.pizzaburger.burger.bun.BurgerBun;
import com.pizzaburger.burger.sauce.BurgerSauce;
import com.pizzaburger.burger.topping.BurgerTopping;

/**
 * {@code Burger} represents a complete burger composed of a bun, sauce, and
 * toppings.
 */
public class Burger extends AbstractMenuItem {
  private BurgerBun bun;
  private BurgerSauce sauce;
  private ArrayList<BurgerTopping> toppingList;
  private ArrayList<AbstractMenuItem> burgerComponents;
  private boolean hasFourOrMoreToppings = false;

  public Burger() {
    this.bun = null;
    this.sauce = null;
    this.toppingList = new ArrayList<BurgerTopping>();
    this.burgerComponents = new ArrayList<AbstractMenuItem>();
  }

  public Burger(BurgerBun bun, BurgerSauce sauce) {
    this.bun = bun;
    this.sauce = sauce;
    this.toppingList = new ArrayList<BurgerTopping>();
    this.burgerComponents = new ArrayList<AbstractMenuItem>();
    addComponent(bun);
    addComponent(sauce);
  }

  public BurgerBun getBun() {
    return this.bun;
  }

  /**
   * Sets the bun and updates the burgerComponents list for display.
   * 
   * @param bun the selected bun
   */
  public void setBun(BurgerBun bun) {
    if (this.bun != null) {
      int index = burgerComponents.indexOf(this.bun);
      if (index != -1) {
        burgerComponents.set(index, bun);
      }
    } else {
      this.addComponent(bun);
    }
    this.bun = bun;
  }


  	/**
	 * In addition to setting toppings, setTopping also appends the topping list
	 * into the burgerComponents list for future displays
	 * 
	 * @param topping the selected toppings
	 */
	public void setTopping(ArrayList<BurgerTopping> toppings) {
		this.toppingList = toppings;
		this.getComponents().addAll(toppings);
	}



  public BurgerSauce getSauce() {
    return this.sauce;
  }

  /**
   * Sets the sauce and updates the burgerComponents list for display.
   * 
   * @param sauce the selected sauce
   */
  public void setSauce(BurgerSauce sauce) {
    if (this.sauce != null) {
      int index = burgerComponents.indexOf(this.sauce);
      if (index != -1) {
        burgerComponents.set(index, sauce);
      }
    } else {
      this.addComponent(sauce);
    }
    this.sauce = sauce;
  }

  public ArrayList<BurgerTopping> getToppings() {
    return this.toppingList;
  }

  /**
   * Adds a topping and updates the burgerComponents list for display.
   * 
   * @param topping the selected topping
   */
  public void addTopping(BurgerTopping topping) {
    if (!burgerComponents.contains(topping)) {
      if (hasFourOrMoreToppings) {
        BurgerTopping firstTopping = toppingList.remove(0);
        burgerComponents.remove(firstTopping);
        toppingList.add(topping);
        burgerComponents.add(topping);
      } else {
        toppingList.add(topping);
        hasFourOrMoreToppings = checkIfFourOrMoreToppings();
        burgerComponents.add(topping);
      }
    }
  }

  public void resetToppings() {
    toppingList = new ArrayList<BurgerTopping>();
    burgerComponents.removeIf(item -> item instanceof BurgerTopping);
    hasFourOrMoreToppings = false;
  }

  public ArrayList<AbstractMenuItem> getComponents() {
    return this.burgerComponents;
  }

  public void addComponent(AbstractMenuItem item) {
    this.burgerComponents.add(item);
  }

  @Override
  public String toNiceString() {
    return "Burger with: " + toString();
  }

  @Override
  public String toString() {
    String burgerDesc = bun + ", " + sauce;
    for (BurgerTopping t : toppingList) {
      burgerDesc += ", " + t.toString();
    }
    return burgerDesc;
  }

  public void display() {
    for (MenuItem m : this.burgerComponents) {
      System.out.printf("%s $%.2f\n", m.toNiceString(), m.getPrice());
    }
  }

  public boolean checkIfFourOrMoreToppings() {
    return this.toppingList.size() >= 4;
  }

  public void displaySorted() {
    Collections.sort(this.burgerComponents);
    display();
  }

  @Override
  public Double getPrice() {
    Double total = 0.0;
    for (MenuItem m : burgerComponents) {
      total += m.getPrice();
    }
    return total;
  }
}
