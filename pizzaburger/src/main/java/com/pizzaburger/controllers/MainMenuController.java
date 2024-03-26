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

/**
 * Controller for the Main Menu view in a build-your-own pizza and burger application.
 * Allows navigation to different parts of the application such as the pizza customization
 * view, burger customization view, and the shopping cart view.
 */
public class MainMenuController implements ShoppingCartConsumer {

    private ShoppingCart shoppingCart;
    private CustomFXMLLoader customLoader;

    @FXML
    private Button pizzaViewButton, burgerViewButton, viewCartButton;

    /**
     * Sets the shopping cart instance for this controller, allowing for cart
     * management and navigation to other views while preserving the cart state.
     *
     * @param shoppingCart the shopping cart to be used by this controller
     */
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
        this.customLoader = new CustomFXMLLoader(this.shoppingCart);
    }

    /**
     * Handles the action of switching to the Pizza customization view.
     *
     * @param event the event that triggered this action
     */
    @FXML
    private void switchToPizzaView(ActionEvent event) {
        try {
            Parent newSceneRoot = customLoader.load("/com/pizzaburger/pizza_view.fxml");
            Scene newScene = new Scene(newSceneRoot);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action of switching to the Burger customization view.
     *
     * @param event the event that triggered this action
     */
    @FXML
    private void switchToBurgerView(ActionEvent event) {
        try {
            Parent newSceneRoot = customLoader.load("/com/pizzaburger/burger_view.fxml");
            Scene newScene = new Scene(newSceneRoot);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action of switching to the Cart view, where users can review
     * their selections and see the total price of their order.
     *
     * @param event the event that triggered this action
     */
    @FXML
    private void switchToCartView(ActionEvent event) {
        try {
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
