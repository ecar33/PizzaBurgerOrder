package com.pizzaburger.controllers;

import com.pizzaburger.cart.ShoppingCart;
import com.pizzaburger.cart.ShoppingCartConsumer;
import com.pizzaburger.pizza.Pizza;
import com.pizzaburger.pizza.PizzaMappings;
import com.pizzaburger.pizza.crust.PizzaCrust;
import com.pizzaburger.pizza.crust.ThinCrust;
import com.pizzaburger.pizza.sauce.PizzaSauce;
import com.pizzaburger.pizza.sauce.TomatoSauce;
import com.pizzaburger.pizza.topping.PizzaTopping;
import com.pizzaburger.util.CustomFXMLLoader;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * Controls the pizza customization view within the application.
 * This controller manages user interactions for building a custom pizza,
 * including selecting crust type, sauce, and toppings.
 */
public class PizzaController implements ShoppingCartConsumer {

    private ShoppingCart shoppingCart;
    private CustomFXMLLoader customLoader;

    private Pizza currentPizza = generateDefaultPizza();

    @FXML
    private ListView<String> toppingsListView;

    @FXML
    private Label sauceLabel, crustLabel;

    @FXML
    private ChoiceBox<String> crustChoiceBox, sauceChoiceBox;

    @FXML
    private Button sausageButton, pepperoniButton, asiagoButton, mozzarellaButton, pepperButton,
            mushroomButton;

    /**
     * Sets the {@link ShoppingCart} instance for this controller.
     * 
     * @param shoppingCart The shopping cart used by the application.
     */
    @Override
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
        this.customLoader = new CustomFXMLLoader(this.shoppingCart);
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the FXML file has been loaded. It populates the choice boxes for
     * crust and sauce with available options and sets their default selections.
     */
    @FXML
    public void initialize() {
        // Example of populating the ChoiceBoxes. Adjust with actual data.
        crustChoiceBox.getItems().addAll("Thin Crust", "Thick Crust", "Cheese Crust");
        sauceChoiceBox.getItems().addAll("Tomato Sauce", "Alfredo Sauce", "White Garlic Sauce");

        // Set default selection
        crustChoiceBox.getSelectionModel().selectFirst();
        sauceChoiceBox.getSelectionModel().selectFirst();

        updateCrustDisplay();
        updateSauceDisplay();
    }

    /**
     * Generates a default pizza with predefined crust and sauce.
     * 
     * @return A pizza object with default settings.
     */
    private Pizza generateDefaultPizza() {
        PizzaSauce tomatoSauce = new TomatoSauce();
        PizzaCrust thickCrust = new ThinCrust();
        Pizza defaultPizza = new Pizza(thickCrust, tomatoSauce);
        return defaultPizza;
    }

    /**
     * Handles the selection of a pizza crust based on user input.
     * 
     * @param event The action event triggered by selecting a crust.
     */
    @FXML
    private void handleSetCrust(ActionEvent event) {
        String selectedCrust = crustChoiceBox.getSelectionModel().getSelectedItem();
        if (!selectedCrust.isEmpty()) {
            PizzaCrust crust = PizzaMappings.crustMapping.get(selectedCrust);
            if (crust != null) {
                currentPizza.setCrust(crust);
            }
        }
        updateCrustDisplay();
    }

    /**
     * Updates the toppings list view with the current toppings on the pizza.
     */
    private void updateToppingsListView() {
        toppingsListView.getItems().clear();

        for (PizzaTopping topping : currentPizza.getToppings()) {
            toppingsListView.getItems().add(topping.toString());
        }
    }

    /**
     * Updates the crust display label with the current pizza's crust.
     */
    private void updateCrustDisplay() {
        String crust = currentPizza.getCrust().toString();
        crustLabel.setText(crust);
    }

    /**
     * Updates the sauce display label with the current pizza's sauce.
     */
    private void updateSauceDisplay() {
        String sauce = currentPizza.getSauce().toString();
        sauceLabel.setText(sauce);
    }

    /**
     * Handles the selection of a pizza sauce based on user input.
     * 
     * @param event The action event triggered by selecting a sauce.
     */
    @FXML
    private void handleSetSauce(ActionEvent event) {
        String selectedSauce = sauceChoiceBox.getSelectionModel().getSelectedItem();
        if (!selectedSauce.isEmpty()) {
            PizzaSauce sauce = PizzaMappings.sauceMapping.get(selectedSauce);
            if (sauce != null) {
                currentPizza.setSauce(sauce);
            }
        }
        updateSauceDisplay();
    }

    /**
     * Adds a topping to the current pizza based on the button pressed.
     * 
     * @param event The action event triggered by a topping button.
     */
    @FXML
    private void handleAddTopping(ActionEvent event) {
        Button button = (Button) event.getSource();
        PizzaTopping topping = PizzaMappings.toppingMapping.get(button.getText());
        if (topping != null) {
            currentPizza.addTopping(topping);
        }
        updateToppingsListView();
    }

    /**
     * Switches the view back to the main menu.
     * 
     * @param event The action event triggered by the menu button.
     */
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

    /**
     * Adds the current pizza to the shopping cart and switches to the cart view.
     * 
     * @param event The action event triggered by adding the pizza to the cart.
     */
    @FXML
    private void handleAddPizza(ActionEvent event) {
        shoppingCart.addPizza(currentPizza);
        switchToCartView(event);
    }

    /**
     * Switches the view to the cart, showing the user's current selections.
     * 
     * @param event The action event triggered by the view cart button.
     */
    @FXML
    private void switchToCartView(ActionEvent event) {
        try {
            if (this.customLoader == null) {
                this.customLoader = new CustomFXMLLoader(this.shoppingCart);
            }
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
     * Resets the current pizza to default settings and updates the UI accordingly.
     * 
     * @param event The action event triggered by the reset button.
     */
    @FXML
    private void restartPizza(ActionEvent event) {
        currentPizza = generateDefaultPizza();
        updateCrustDisplay();
        updateSauceDisplay();

        currentPizza.resetToppings();
        updateToppingsListView();
    }
}
