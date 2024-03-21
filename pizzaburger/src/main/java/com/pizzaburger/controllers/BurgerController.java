package com.pizzaburger.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;

public class BurgerController {
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

        toppingCheckBoxList = Arrays.asList(cheddarCheckBox, pepperjackCheckBox, baconCheckBox, pattyCheckBox, lettuceCheckBox, tomatoCheckBox);

        // Example usage: Print all checkbox texts
        toppingCheckBoxList.forEach(checkBox -> System.out.println(checkBox.getText()));
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