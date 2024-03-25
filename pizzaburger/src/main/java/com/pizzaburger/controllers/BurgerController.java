package com.pizzaburger.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

import com.pizzaburger.cart.ShoppingCart;
import com.pizzaburger.cart.ShoppingCartConsumer;
import com.pizzaburger.burger.*;
import com.pizzaburger.burger.bun.*;
import com.pizzaburger.burger.sauce.*;
import com.pizzaburger.burger.topping.*;
import com.pizzaburger.util.CustomFXMLLoader;

import javafx.event.ActionEvent;

public class BurgerController implements ShoppingCartConsumer {

    private ShoppingCart shoppingCart;
    private CustomFXMLLoader customLoader;

    @FXML
    private Label bunLabel, sauceLabel;

    @FXML
    private ChoiceBox<String> sauceChoiceBox, bunChoiceBox;

    @FXML
    private CheckBox cheddarCheckBox, pepperjackCheckBox, baconCheckBox, pattyCheckBox, lettuceCheckBox, tomatoCheckBox;

    @FXML
    private ListView<String> toppingsListView;

    private List<CheckBox> toppingCheckBoxList;
    private Burger currentBurger = generateDefaultBurger();

    @FXML
    public void initialize() {
        sauceChoiceBox.getItems().addAll("Ketchup", "Spicy Mayo", "Mustard");
        bunChoiceBox.getItems().addAll("Sesame Seed", "Classic", "Pretzel Bun");

        sauceChoiceBox.getSelectionModel().selectFirst();
        bunChoiceBox.getSelectionModel().selectFirst();

        updateBunDisplay();
        updateSauceDisplay();

        toppingCheckBoxList = Arrays.asList(cheddarCheckBox, pepperjackCheckBox, baconCheckBox, pattyCheckBox,
                lettuceCheckBox, tomatoCheckBox);

        // Initialize the currentBurger with default selections
        currentBurger = new Burger(BurgerMappings.bunMapping.get(bunChoiceBox.getValue()),
                BurgerMappings.sauceMapping.get(sauceChoiceBox.getValue()));
    }

    private Burger generateDefaultBurger() {
        BurgerSauce ketchupSauce = new KetchupSauce();
        BurgerBun sesameSeedBun = new SesameSeedBun();
        Burger defaultBurger = new Burger(sesameSeedBun, ketchupSauce);
        return defaultBurger;
    }

    @Override
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
        this.customLoader = new CustomFXMLLoader(this.shoppingCart);
    }

    @FXML
    private void handleAddBun(ActionEvent event) {
        String selectedBun = bunChoiceBox.getSelectionModel().getSelectedItem();
        BurgerBun bun = BurgerMappings.bunMapping.get(selectedBun);
        if (bun != null) {
            currentBurger.setBun(bun);
            updateBunDisplay();
        }
    }

    @FXML
    private void handleAddSauce(ActionEvent event) {
        String selectedSauce = sauceChoiceBox.getSelectionModel().getSelectedItem();
        BurgerSauce sauce = BurgerMappings.sauceMapping.get(selectedSauce);
        if (sauce != null) {
            currentBurger.setSauce(sauce);
            updateSauceDisplay();
        }
    }

    @FXML
    private void handleAddTopping(ActionEvent event) {
        toppingCheckBoxList.forEach(checkBox -> {
            if (checkBox.isSelected()) {
                BurgerTopping topping = BurgerMappings.toppingMapping.get(checkBox.getText());
                if (topping != null) {
                    currentBurger.addTopping(topping);
                    updateToppingsDisplay();
                }
            }
        });
    }

    @FXML
    private void handleAddBurger(ActionEvent event) {
        shoppingCart.addBurger(currentBurger);
        switchToCartView(event); // Assuming you implement this method similarly to PizzaController
    }

    // Method to switch back to the main menu
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

    // Method to switch to the cart view, showing the current order
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

    // Method to reset the burger customization for a new order
    @FXML
    private void restartBurger(ActionEvent event) {
        currentBurger = new Burger(BurgerMappings.bunMapping.get(bunChoiceBox.getValue()),
                BurgerMappings.sauceMapping.get(sauceChoiceBox.getValue()));
        resetToppingsSelection();
        // You may also want to reset the ChoiceBoxes to their default selection here
        sauceChoiceBox.getSelectionModel().selectFirst();
        bunChoiceBox.getSelectionModel().selectFirst();
    }

    // Helper method to reset the toppings selection UI
    private void resetToppingsSelection() {
        toppingCheckBoxList.forEach(checkBox -> checkBox.setSelected(false));
    }

    // Updates the display for the selected bun
    private void updateBunDisplay() {
        if (currentBurger.getBun() != null) {
            // Assuming your BurgerBun class has a toString method that returns the bun type
            String bunType = currentBurger.getBun().toString();
            bunLabel.setText(bunType);
        }
    }

    // Updates the display for the selected sauce
    private void updateSauceDisplay() {
        if (currentBurger.getSauce() != null) {
            // Assuming your BurgerSauce class has a toString method that returns the sauce
            // type
            String sauceType = currentBurger.getSauce().toString();
            sauceLabel.setText(sauceType);
        }
    }

    // Updates the display for the selected toppings
    private void updateToppingsDisplay() {
        toppingsListView.getItems().clear(); // Clear the list view first
        for (BurgerTopping topping : currentBurger.getToppings()) {
            // Assuming your BurgerTopping class has a toString method that returns the
            // topping name
            String toppingName = topping.toString();
            toppingsListView.getItems().add(toppingName); // Add each topping to the list view
        }
    }

}
