package com.pizzaburger.cart;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import com.pizzaburger.burger.*;
import com.pizzaburger.pizza.*;

/**
 * Represents a shopping cart that can hold pizzas and burgers.
 * Provides functionality to add items, clear the cart, and retrieve the items.
 */
public class ShoppingCart {
    private List<Pizza> pizzas;
    private List<Burger> burgers;

    /**
     * Constructs a new ShoppingCart instance with empty lists for pizzas and burgers.
     */
    public ShoppingCart() {
        this.pizzas = new ArrayList<>();
        this.burgers = new ArrayList<>();
    }

    /**
     * Adds a pizza to the cart and sorts the list of pizzas.
     * 
     * @param pizza The pizza to add to the cart.
     */
    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
        sortPizzas();
    }

    /**
     * Adds a burger to the cart and sorts the list of burgers.
     * 
     * @param burger The burger to add to the cart.
     */
    public void addBurger(Burger burger) {
        this.burgers.add(burger);
        sortBurgers();
    }

    /**
     * Returns an unmodifiable list of pizzas in the cart.
     * 
     * @return A list of pizzas currently in the cart.
     */
    public List<Pizza> getPizzas() {
        return Collections.unmodifiableList(pizzas);
    }

    /**
     * Sorts the list of pizzas in the cart.
     * Assumes that Pizza implements Comparable interface.
     */
    private void sortPizzas() {
        Collections.sort(this.pizzas);
    }

    /**
     * Sorts the list of burgers in the cart.
     * Assumes that Burger implements Comparable interface.
     */
    private void sortBurgers() {
        Collections.sort(this.burgers);
    }

    /**
     * Clears all items from the cart, resetting it to empty.
     */
    public void clearCart() {
        this.pizzas = new ArrayList<>();
        this.burgers = new ArrayList<>();
    }

    /**
     * Returns an unmodifiable list of burgers in the cart.
     * 
     * @return A list of burgers currently in the cart.
     */
    public List<Burger> getBurgers() {
        return Collections.unmodifiableList(burgers);
    }
}
