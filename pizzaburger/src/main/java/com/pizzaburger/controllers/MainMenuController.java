package com.pizzaburger.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;

public class MainMenuController {

    @FXML
    private Button pizzaViewButton, burgerViewButton, viewCartButton;

    @FXML
    private void switchPizzaScene(ActionEvent event) {
        try {
            // Load the FXML file for the new scene

            URL fxmlLocation = MainMenuController.class.getResource("/com/pizzaburger/pizza_view.fxml");

            Parent newSceneRoot = FXMLLoader.load(fxmlLocation);
            Scene newScene = new Scene(newSceneRoot);
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(newScene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchBurgerScene(ActionEvent event) {
        try {
            // Load the FXML file for the new scene

            URL fxmlLocation = MainMenuController.class.getResource("/com/pizzaburger/burger_view.fxml");

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



