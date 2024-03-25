package com.pizzaburger.util;

import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.Parent;
import java.net.URL;
import com.pizzaburger.cart.ShoppingCart;
import com.pizzaburger.cart.ShoppingCartConsumer;

public class CustomFXMLLoader {

    private final ShoppingCart shoppingCart;

    public CustomFXMLLoader(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Parent load(String fxmlPath) throws IOException {
        URL fxmlLocation = getClass().getResource(fxmlPath);
        if (fxmlLocation == null) {
            throw new IllegalArgumentException("FXML file not found: " + fxmlPath);
        }
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Parent root = loader.load();
        
        Object controller = loader.getController();
        if (controller instanceof ShoppingCartConsumer) {
            ((ShoppingCartConsumer) controller).setShoppingCart(shoppingCart);
        }

        return root;
    }
}