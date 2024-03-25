package com.pizzaburger.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import com.pizzaburger.cart.ShoppingCart;
import com.pizzaburger.cart.ShoppingCartConsumer;
import com.pizzaburger.pizza.Pizza;
import com.pizzaburger.pizza.topping.PizzaTopping;
import com.pizzaburger.util.CustomFXMLLoader;

import javafx.event.ActionEvent;

public class CartController implements ShoppingCartConsumer {

  private ShoppingCart shoppingCart;
  private CustomFXMLLoader customLoader;

  @FXML
  ListView<String> pizzaListView;

  public void setShoppingCart(ShoppingCart shoppingCart) {
    this.shoppingCart = shoppingCart;
    this.customLoader = new CustomFXMLLoader(this.shoppingCart); 
    updatePizzaDisplay();
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

  private void updatePizzaDisplay() {
    for (Pizza pizza : shoppingCart.getPizzas()) {
      pizzaListView.getItems().add(pizza.toString());
    }
  }

}
