package com.pizzaburger.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import com.pizzaburger.cart.ShoppingCart;
import com.pizzaburger.cart.ShoppingCartConsumer;
import com.pizzaburger.util.CustomFXMLLoader;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import javafx.event.ActionEvent;

/**
 * Controller for managing the shopping cart view in the application.
 * It displays the current items in the cart, including pizzas and burgers,
 * and calculates the subtotal for each category and the total price.
 */
public class CartController implements ShoppingCartConsumer {

  private ShoppingCart shoppingCart;
  private CustomFXMLLoader customLoader;

  @FXML
  ListView<String> pizzaListView, burgerListView;

  @FXML
  Label burgerSubtotalLabel, pizzaSubtotalLabel, totalPriceLabel;

  // Subtotal properties for burgers and pizzas
  private final DoubleProperty burgerSubtotal = new SimpleDoubleProperty(0.0);
  private final DoubleProperty pizzaSubtotal = new SimpleDoubleProperty(0.0);

  /**
   * Sets the shopping cart for this controller and initializes the view
   * components.
   * It also binds the total price label to the sum of pizza and burger subtotals.
   *
   * @param shoppingCart The shopping cart to be displayed and managed.
   */
  public void setShoppingCart(ShoppingCart shoppingCart) {
    this.shoppingCart = shoppingCart;
    this.customLoader = new CustomFXMLLoader(this.shoppingCart);
    updatePizzaDisplay();
    updateBurgerDisplay();
    bindTotalLabel();
  }

  /**
   * Binds the total price label to the combined total of pizza and burger
   * subtotals,
   * formatted as a currency value.
   */
  private void bindTotalLabel() {
    totalPriceLabel.textProperty().bind(burgerSubtotal.add(pizzaSubtotal).asString("$%.2f"));
  }

  /**
   * Switches the view back to the main menu.
   * 
   * @param event The action event triggered by the user's interaction.
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

  /**
   * Switches the view to the receipt view, showing a summary of the order.
   * 
   * @param event The action event triggered by the user's interaction.
   */
  @FXML
  private void switchToReceiptView(ActionEvent event) {
    try {
      if (this.customLoader == null) {
        this.customLoader = new CustomFXMLLoader(this.shoppingCart);
      }
      Parent newSceneRoot = customLoader.load("/com/pizzaburger/receipt.fxml");
      Scene newScene = new Scene(newSceneRoot);

      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

      stage.setScene(newScene);
      stage.show();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Updates the pizza list view and subtotal based on the current items in the
   * shopping cart.
   */
  private void updatePizzaDisplay() {
    pizzaSubtotal.set(0.0);
    shoppingCart.getPizzas().forEach(pizza -> {
      pizzaListView.getItems().add(pizza.toString() + " with price " + String.format("$%.2f", pizza.getPrice()));
      pizzaSubtotal.set(pizzaSubtotal.get() + pizza.getPrice());
    });
    pizzaSubtotalLabel.setText(String.format("$%.2f", pizzaSubtotal.get()));
  }

  /**
   * Updates the burger list view and subtotal based on the current items in the
   * shopping cart.
   */
  private void updateBurgerDisplay() {
    burgerSubtotal.set(0.0); // Reset subtotal
    shoppingCart.getBurgers().forEach(burger -> {
      burgerListView.getItems().add(burger.toString() + " with price " + String.format("$%.2f", burger.getPrice()));
      burgerSubtotal.set(burgerSubtotal.get() + burger.getPrice());
    });
    burgerSubtotalLabel.setText(String.format("$%.2f", burgerSubtotal.get()));
  }

}
