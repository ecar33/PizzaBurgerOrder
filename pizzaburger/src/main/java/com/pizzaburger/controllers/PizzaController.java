package com.pizzaburger.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.pizzaburger.pizza.*;
import com.pizzaburger.pizza.crust.*;
import com.pizzaburger.pizza.sauce.*;
import com.pizzaburger.pizza.topping.*;

import javafx.event.ActionEvent;

public class PizzaController {

    private Pizza currentPizza = new Pizza();

    @FXML
    private ListView<String> toppingsListView;
    
    @FXML
    private Label sauceLabel, crustLabel;

    @FXML
    private ChoiceBox<String> crustChoiceBox, sauceChoiceBox;

    @FXML
    private Button addCrustButton, addSauceButton, addMeatToppingsButton, addCheeseToppingsButton,
            addVeggieToppingsButton, addPizzaButton, checkoutButton;

    @FXML
    private Button sausageButton, pepperoniButton, asiagoButton, mozzarellaButton, pepperButton,
            mushroomButton;

    // Method to initialize your controller. Called after the FXML fields are
    // populated.
    @FXML
    public void initialize() {
        // Example of populating the ChoiceBoxes. Adjust with actual data.
        crustChoiceBox.getItems().addAll("Thin Crust", "Thick Crust", "Cheese Crust");
        sauceChoiceBox.getItems().addAll("Tomato Sauce", "Alfredo Sauce", "White Garlic Sauce");

        // Set default selection
        crustChoiceBox.getSelectionModel().selectFirst();
        sauceChoiceBox.getSelectionModel().selectFirst();
    }

    // Example of a handler method for adding a crust. Adapt as necessary.
    @FXML
    private void handleAddCrust(ActionEvent event) {
        String selectedCrust = crustChoiceBox.getSelectionModel().getSelectedItem();
        if (!selectedCrust.isEmpty()) {
            PizzaCrust crust = PizzaMappings.crustMapping.get(selectedCrust);
            if (crust != null) {
                currentPizza.setCrust(crust);
            }
        }
        updateCrustDisplay(currentPizza);
    }

    public void updateToppingsListView(Pizza pizza) {
        toppingsListView.getItems().clear();

        for (PizzaTopping topping : pizza.getToppings()) {
            toppingsListView.getItems().add(topping.toString());
        }
    }

    public void updateCrustDisplay(Pizza pizza) {
        String crust = pizza.getCrust().toString();
        crustLabel.setText(crust);
    }

    public void updateSauceDisplay(Pizza pizza) {
        String sauce = pizza.getSauce().toString();
        sauceLabel.setText(sauce);
    }

    @FXML
    private void handleAddSauce(ActionEvent event) {
        String selectedSauce = sauceChoiceBox.getSelectionModel().getSelectedItem();
        if (!selectedSauce.isEmpty()) {
            PizzaSauce sauce = PizzaMappings.sauceMapping.get(selectedSauce);
            if (sauce != null) {
                currentPizza.setSauce(sauce);
            }
        }
        updateSauceDisplay(currentPizza);
    }

    @FXML
    private void handleAddTopping(ActionEvent event) {
        Button button = (Button) event.getSource();
        PizzaTopping topping = PizzaMappings.toppingMapping.get(button.getText());
        if (topping != null) {
            currentPizza.addTopping(topping);
        }
        updateToppingsListView(currentPizza);
    }

    @FXML
    private void switchToMenuView(ActionEvent event) {
        try {
            // Load the FXML file for the new scene

            URL fxmlLocation = MainMenuController.class.getResource("/com/pizzaburger/main_menu.fxml");

            Parent newSceneRoot = FXMLLoader.load(fxmlLocation);
            Scene newScene = new Scene(newSceneRoot);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(newScene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
