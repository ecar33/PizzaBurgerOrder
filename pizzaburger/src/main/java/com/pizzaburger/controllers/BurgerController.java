package com.pizzaburger.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

import com.pizzaburger.cart.ShoppingCart;
import com.pizzaburger.cart.ShoppingCartConsumer;
import com.pizzaburger.util.CustomFXMLLoader;

import javafx.event.ActionEvent;

public class BurgerController implements ShoppingCartConsumer {

    private ShoppingCart shoppingCart;
    private CustomFXMLLoader customLoader;

    @FXML
    ChoiceBox<String> sauceChoiceBox, bunChoiceBox;

    @FXML
    private CheckBox cheddarCheckBox, pepperjackCheckBox, baconCheckBox, pattyCheckBox, lettuceCheckBox, tomatoCheckBox;

    private List<CheckBox> toppingCheckBoxList;

    @FXML
    public void initialize() {
        // Example of populating the ChoiceBoxes. Adjust with actual data.
        sauceChoiceBox.getItems().addAll("Ketchup", "Spicy Mayo", "Mustard");
        bunChoiceBox.getItems().addAll("Sesame Seed", "Classic", "Pretzel Bun");

        sauceChoiceBox.getSelectionModel().selectFirst();
        bunChoiceBox.getSelectionModel().selectFirst();

        toppingCheckBoxList = Arrays.asList(cheddarCheckBox, pepperjackCheckBox, baconCheckBox, pattyCheckBox,
                lettuceCheckBox, tomatoCheckBox);

        // Example usage: Print all checkbox texts
        toppingCheckBoxList.forEach(checkBox -> System.out.println(checkBox.getText()));
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
        this.customLoader = new CustomFXMLLoader(this.shoppingCart); 
    }
    @FXML
    private void handleAddBun(ActionEvent event) {
        String selectedBun = bunChoiceBox.getSelectionModel().getSelectedItem();
        if (!selectedBun.isEmpty()) {
            System.out.println("Bun added: " + selectedBun);
        }
    }

    @FXML
    private void handleAddSauce(ActionEvent event) {
        String selectedSauce = sauceChoiceBox.getSelectionModel().getSelectedItem();
        if (!selectedSauce.isEmpty()) {
            System.out.println("Sauce added: " + selectedSauce);
        }
    }

    @FXML
    private void handleAddTopping(ActionEvent event) {
        toppingCheckBoxList.forEach(checkBox -> {
            if (checkBox.isSelected()) {
                System.out.println(checkBox.getText() + " is selected.");
            }
        });
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
}