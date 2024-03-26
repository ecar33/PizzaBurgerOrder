package com.pizzaburger.cart;

/**
 * Defines an interface for objects that can consume a {@link ShoppingCart}.
 * This allows for the dynamic assignment of a shopping cart to various
 * consumers.
 */
public interface ShoppingCartConsumer {

  /**
   * Sets the {@link ShoppingCart} instance to be used by the consumer.
   * 
   * @param shoppingCart The {@link ShoppingCart} instance to be assigned.
   */
  void setShoppingCart(ShoppingCart shoppingCart);
}