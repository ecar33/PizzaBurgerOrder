package com.pizzaburger.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import com.pizzaburger.cart.ShoppingCart;
import com.pizzaburger.cart.ShoppingCartConsumer;
import com.pizzaburger.pizza.Pizza;
import com.pizzaburger.burger.Burger;

import com.pizzaburger.util.CustomFXMLLoader;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import javafx.event.ActionEvent;

/**
 * Controller for handling the receipt view in the ordering app.
 * Displays a detailed receipt for the user's order, including itemized
 * list of pizzas and burgers, their prices, and the total amount due.
 */
public class ReciptController implements ShoppingCartConsumer {

  private ShoppingCart shoppingCart;
  private CustomFXMLLoader customLoader;

  @FXML
  ListView<String> receiptListView;

  @FXML
  Button newOrderButton;

  // Properties to hold the subtotals of burgers and pizzas
  private final DoubleProperty burgerSubtotal = new SimpleDoubleProperty(0.0);
  private final DoubleProperty pizzaSubtotal = new SimpleDoubleProperty(0.0);

  /**
   * Sets the shopping cart instance for this controller and generates the initial
   * receipt.
   * 
   * @param shoppingCart The ShoppingCart instance containing the current order.
   */
  @Override
  public void setShoppingCart(ShoppingCart shoppingCart) {
    this.shoppingCart = shoppingCart;
    this.customLoader = new CustomFXMLLoader(this.shoppingCart);
    generateReceipt();
  }

  /**
   * Generates the receipt for the current order, listing each item with its price
   * and
   * calculating the total amount due.
   */
  public void generateReceipt() {
    // Reset subtotals
    burgerSubtotal.set(0.0);
    pizzaSubtotal.set(0.0);

    // Add burgers to the receipt
    for (Burger burger : shoppingCart.getBurgers()) {
      String burgerDescription = burger.toNiceString();
      String burgerPrice = String.format(" $%.2f", burger.getPrice());
      receiptListView.getItems().add(burgerDescription + burgerPrice);
      burgerSubtotal.set(burgerSubtotal.get() + burger.getPrice());
    }

    // Add pizzas to the receipt
    for (Pizza pizza : shoppingCart.getPizzas()) {
      String pizzaDescription = pizza.toNiceString();
      String pizzaPrice = String.format(" $%.2f", pizza.getPrice());
      receiptListView.getItems().add(pizzaDescription + pizzaPrice);
      pizzaSubtotal.set(pizzaSubtotal.get() + pizza.getPrice());
    }

    // Calculate and display total
    double total = burgerSubtotal.get() + pizzaSubtotal.get();
    receiptListView.getItems().add(String.format("Total: $%.2f", total));

  }

  /**
   * Initiates a new order by clearing the shopping cart and switching back to the
   * main menu view.
   * 
   * @param event The action event that triggered this method.
   */
  @FXML
  private void startNewOrder(ActionEvent event) {
    // Clear the shopping cart for the next order
    shoppingCart.clearCart();
    switchToMenuView(event);
  }

  /**
   * Switches the view back to the main menu, allowing the user to start building
   * a new order.
   * 
   * @param event The action event that triggered this method.
   */
  @FXML
  private void switchToMenuView(ActionEvent event) {
    try {
      if (this.customLoader == null) {
        this.customLoader = new CustomFXMLLoader(this.shoppingCart);
      }
      Parent newSceneRoot = customLoader.load("/com/pizzaburger/main_menu.fxml");
      Scene newScene = new Scene(newSceneRoot);

      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

      stage.setScene(newScene);
      stage.show();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
