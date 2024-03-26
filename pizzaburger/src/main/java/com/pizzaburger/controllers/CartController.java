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

public class CartController implements ShoppingCartConsumer {

  private ShoppingCart shoppingCart;
  private CustomFXMLLoader customLoader;

  @FXML
  ListView<String> pizzaListView, burgerListView;

  @FXML
  Label burgerSubtotalLabel, pizzaSubtotalLabel, totalPriceLabel;

  // Subtotal properties
  private final DoubleProperty burgerSubtotal = new SimpleDoubleProperty(0.0);
  private final DoubleProperty pizzaSubtotal = new SimpleDoubleProperty(0.0);

  public void setShoppingCart(ShoppingCart shoppingCart) {
    this.shoppingCart = shoppingCart;
    this.customLoader = new CustomFXMLLoader(this.shoppingCart);
    updatePizzaDisplay();
    updateBurgerDisplay();
    bindTotalLabel();
  }
  

  private void bindTotalLabel() {
    totalPriceLabel.textProperty().bind(burgerSubtotal.add(pizzaSubtotal).asString("$%.2f"));
  }

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

  private void updatePizzaDisplay() {
    pizzaSubtotal.set(0.0);
    shoppingCart.getPizzas().forEach(pizza -> {
      pizzaListView.getItems().add(pizza.toString() + " with price " + String.format("$%.2f", pizza.getPrice()));
      pizzaSubtotal.set(pizzaSubtotal.get() + pizza.getPrice());
    });
    pizzaSubtotalLabel.setText(String.format("$%.2f", pizzaSubtotal.get()));
  }

  private void updateBurgerDisplay() {
    burgerSubtotal.set(0.0); // Reset subtotal
    shoppingCart.getBurgers().forEach(burger -> {
      burgerListView.getItems().add(burger.toString() + " with price " + String.format("$%.2f", burger.getPrice()));
      burgerSubtotal.set(burgerSubtotal.get() + burger.getPrice());
    });
    burgerSubtotalLabel.setText(String.format("$%.2f", burgerSubtotal.get()));
  }

}
