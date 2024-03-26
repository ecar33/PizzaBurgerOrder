package com.pizzaburger.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import com.pizzaburger.cart.ShoppingCart;
import com.pizzaburger.cart.ShoppingCartConsumer;
import com.pizzaburger.burger.*;
import com.pizzaburger.burger.bun.*;
import com.pizzaburger.burger.sauce.*;
import com.pizzaburger.burger.topping.*;
import com.pizzaburger.util.CustomFXMLLoader;

import javafx.event.ActionEvent;

/**
 * Controls the UI for burger customization, handling interactions for bun,
 * sauce, and topping selection,
 * and managing transitions to other views.
 */

public class BurgerController implements ShoppingCartConsumer {

    private ShoppingCart shoppingCart;
    private CustomFXMLLoader customLoader;

    @FXML
    private Label bunLabel, sauceLabel;

    @FXML
    private ChoiceBox<String> sauceChoiceBox, bunChoiceBox;

    @FXML
    private Button cheddarCheckBox, pepperjackCheckBox, baconCheckBox, pattyCheckBox, lettuceCheckBox, tomatoCheckBox;

    @FXML
    private ListView<String> toppingsListView;

    private Burger currentBurger = generateDefaultBurger();

    /**
     * Initializes the controller, setting up the initial state of the UI components
     * and registering event handlers.
     */

    @FXML
    public void initialize() {

        sauceChoiceBox.getItems().addAll("Ketchup", "Spicy Mayo", "Mustard");
        bunChoiceBox.getItems().addAll("Sesame Seed", "Classic", "Pretzel Bun");

        sauceChoiceBox.getSelectionModel().selectFirst();
        bunChoiceBox.getSelectionModel().selectFirst();

        updateBunDisplay();
        updateSauceDisplay();

        // Initialize the currentBurger with default selections
    }

    /**
     * Generates and returns a {@link Burger} instance with default settings.
     * This typically includes a default bun, sauce, and no toppings.
     * 
     * @return A {@link Burger} instance with default settings.
     */

    private Burger generateDefaultBurger() {
        BurgerSauce ketchupSauce = new KetchupSauce();
        BurgerBun sesameSeedBun = new SesameSeedBun();
        Burger defaultBurger = new Burger(sesameSeedBun, ketchupSauce);
        return defaultBurger;
    }

    /**
     * Assigns a {@link ShoppingCart} to this controller and initializes any
     * necessary components
     * that depend on the shopping cart.
     * 
     * @param shoppingCart The shopping cart to assign to this controller.
     */

    @Override
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
        this.customLoader = new CustomFXMLLoader(this.shoppingCart);
    }

    /**
     * Handles the event to set the selected bun type for the current burger based
     * on user selection.
     * 
     * @param event The event triggered by selecting a bun type.
     */
    @FXML
    private void handleSetBun(ActionEvent event) {
        String selectedBun = bunChoiceBox.getSelectionModel().getSelectedItem();
        BurgerBun bun = BurgerMappings.bunMapping.get(selectedBun);
        if (bun != null) {
            currentBurger.setBun(bun);
            updateBunDisplay();
        }
    }

    /**
     * Handles the event to set the selected sauce type for the current burger based
     * on user selection.
     * 
     * @param event The event triggered by selecting a sauce type.
     */
    @FXML
    private void handleSetSauce(ActionEvent event) {
        String selectedSauce = sauceChoiceBox.getSelectionModel().getSelectedItem();
        BurgerSauce sauce = BurgerMappings.sauceMapping.get(selectedSauce);
        if (sauce != null) {
            currentBurger.setSauce(sauce);
            updateSauceDisplay();
        }
    }

    /**
     * Handles the event to add a topping to the current burger based on user
     * interaction.
     * 
     * @param event The event triggered by selecting a topping.
     */
    @FXML
    private void handleAddTopping(ActionEvent event) {
        Button button = (Button) event.getSource();
        BurgerTopping topping = BurgerMappings.toppingMapping.get(button.getText());
        if (topping != null) {
            currentBurger.addTopping(topping);
        }
        updateToppingsListView();
    }

    /**
     * Adds the current burger to the shopping cart and switches the view to the
     * cart view.
     * 
     * @param event The event triggered by the add to cart action.
     */
    @FXML
    private void handleAddBurger(ActionEvent event) {
        shoppingCart.addBurger(currentBurger);
        switchToCartView(event);
    }

    /**
     * Switches the view to the main menu, allowing the user to navigate back to the
     * start.
     * 
     * @param event The event triggered by the navigation action.
     */
    @FXML
    private void switchToMenuView(ActionEvent event) {
        try {
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
     * Switches the view to the cart view, displaying the current items in the
     * shopping cart.
     * 
     * @param event The event triggered by the navigation action.
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

    /**
     * Resets the burger customization, setting it back to default settings.
     * This method is triggered by a UI action, typically a button press.
     * 
     * @param event The event triggered by the reset action.
     */
    @FXML
    private void restartBurger(ActionEvent event) {
        currentBurger = generateDefaultBurger();
        updateBunDisplay();
        updateSauceDisplay();

        currentBurger.resetToppings();
        updateToppingsListView();

    }

    /**
     * Updates the display to show the currently selected bun type in the UI.
     */
    private void updateBunDisplay() {
        String bunType = currentBurger.getBun().toString();
        bunLabel.setText(bunType);
    }

    /**
     * Updates the display to show the currently selected sauce type
     * in the UI.
     */
    private void updateSauceDisplay() {
        String sauceType = currentBurger.getSauce().toString();
        sauceLabel.setText(sauceType);
    }

    /**
     * Updates the toppings list view to display all the toppings
     * currently added to the burger.
     */
    private void updateToppingsListView() {
        toppingsListView.getItems().clear();

        for (BurgerTopping topping : currentBurger.getToppings()) {
            toppingsListView.getItems().add(topping.toString());
        }
    }

}
