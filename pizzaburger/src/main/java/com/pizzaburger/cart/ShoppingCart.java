package com.pizzaburger.cart;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import com.pizzaburger.burger.*;
import com.pizzaburger.pizza.*;

public class ShoppingCart {
    private List<Pizza> pizzas;
    private List<Burger> burgers;

    public ShoppingCart() {
        this.pizzas = new ArrayList<>();
        this.burgers = new ArrayList<>();
    }

    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
        sortPizzas();
    }

    public void addBurger(Burger burger) {
        this.burgers.add(burger);
        sortBurgers();
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void sortPizzas() {
        Collections.sort(this.pizzas);
    }

    public void sortBurgers() {
        Collections.sort(this.burgers);
    }

    public void clearCart() {
        this.pizzas = new ArrayList<>();
        this.burgers = new ArrayList<>();
    }

    // public void printCart() {
    // System.out.println("This is your cart so far: ");
    // for (Pizza pizza : pizzas) {
    // System.out.println(pizza.toString());
    // }
    // }

    public List<Burger> getBurgers() {
        return burgers;
    }
}