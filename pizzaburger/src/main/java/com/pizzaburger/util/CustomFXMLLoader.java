package com.pizzaburger.util;

import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.Parent;
import java.net.URL;
import com.pizzaburger.cart.ShoppingCart;
import com.pizzaburger.cart.ShoppingCartConsumer;

/**
 * A utility class for loading FXML files that also injects a shared {@link ShoppingCart}
 * instance into controllers implementing {@link ShoppingCartConsumer}.
 */
public class CustomFXMLLoader {

    private final ShoppingCart shoppingCart;

    /**
     * Constructs a new CustomFXMLLoader with a specified {@link ShoppingCart}.
     *
     * @param shoppingCart the shared ShoppingCart instance to be injected into controllers.
     */
    public CustomFXMLLoader(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /**
     * Loads an FXML file from a specified path, initializes its controller (if it implements
     * {@link ShoppingCartConsumer}), and injects the shared {@link ShoppingCart} into it.
     * 
     * @param fxmlPath the relative path to the FXML file to be loaded.
     * @return the root {@link Parent} node of the loaded FXML file.
     * @throws IOException if the FXML file cannot be loaded.
     * @throws IllegalArgumentException if the FXML file is not found at the specified path.
     */
    public Parent load(String fxmlPath) throws IOException {
        URL fxmlLocation = getClass().getResource(fxmlPath);
        if (fxmlLocation == null) {
            throw new IllegalArgumentException("FXML file not found: " + fxmlPath);
        }
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Parent root = loader.load();
        
        // Inject the ShoppingCart into the controller if it's a ShoppingCartConsumer.
        Object controller = loader.getController();
        if (controller instanceof ShoppingCartConsumer) {
            ((ShoppingCartConsumer) controller).setShoppingCart(shoppingCart);
        }

        return root;
    }
}
