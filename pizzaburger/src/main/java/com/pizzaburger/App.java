package com.pizzaburger;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import com.pizzaburger.cart.ShoppingCart;
import com.pizzaburger.util.CustomFXMLLoader;

/**
 * JavaFX App
 */

 public class App extends Application {

    private static Scene scene;
    private ShoppingCart shoppingCart = new ShoppingCart();

    @Override
    public void start(Stage stage) throws Exception {
        CustomFXMLLoader customLoader = new CustomFXMLLoader(shoppingCart);
        Parent root = customLoader.load("/com/pizzaburger/main_menu.fxml");
        
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}