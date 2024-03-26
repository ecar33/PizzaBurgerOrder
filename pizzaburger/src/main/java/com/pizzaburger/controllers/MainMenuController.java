package com.pizzaburger.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.pizzaburger.cart.ShoppingCart;
import com.pizzaburger.cart.ShoppingCartConsumer;
import com.pizzaburger.util.CustomFXMLLoader;
import javafx.event.ActionEvent;

public class MainMenuController implements ShoppingCartConsumer {

    private ShoppingCart shoppingCart;
    private CustomFXMLLoader customLoader;

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
        this.customLoader = new CustomFXMLLoader(this.shoppingCart);
    }

    @FXML
    private Button pizzaViewButton, burgerViewButton, viewCartButton;


    @FXML
    private void switchToPizzaView(ActionEvent event) {
      try {
        if (this.customLoader == null) {
          this.customLoader = new CustomFXMLLoader(this.shoppingCart);
        }
        Parent newSceneRoot = customLoader.load("/com/pizzaburger/pizza_view.fxml");
        Scene newScene = new Scene(newSceneRoot);
  
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
  
        stage.setScene(newScene);
        stage.show();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  

    @FXML
    private void switchToBurgerView(ActionEvent event) {
      try {
        if (this.customLoader == null) {
          this.customLoader = new CustomFXMLLoader(this.shoppingCart);
        }
        Parent newSceneRoot = customLoader.load("/com/pizzaburger/burger_view.fxml");
        Scene newScene = new Scene(newSceneRoot);
  
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
  
        stage.setScene(newScene);
        stage.show();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    @FXML
    private void switchToCartView(ActionEvent event) {
        try {
            if (this.customLoader == null) {
                this.customLoader = new CustomFXMLLoader(this.shoppingCart);
            }
            Parent newSceneRoot = customLoader.load("/com/pizzaburger/cart.fxml");
            Scene newScene = new Scene(newSceneRoot);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
