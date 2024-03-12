package com.pizzaburger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
public class PrimaryController {

    @FXML
    private ChoiceBox<String> crustChoiceBox, sauceChoiceBox;
    
    
    // @FXML
    // private Button addCrustButton, addSauceButton, addMeatToppingsButton, addCheeseToppingsButton, addVeggieToppingsButton, addPizzaButton, checkoutButton;
    
    // @FXML
    // private CheckBox sausageCheckBox, pepperoniCheckBox, asiagoCheckBox, mozzarellaCheckBox, pepperCheckBox, mushroomCheckBox;

    // Method to initialize your controller. Called after the FXML fields are populated.
    @FXML
    public void initialize() {
        // Example of populating the ChoiceBoxes. Adjust with actual data.
        crustChoiceBox.getItems().addAll("Thin Crust", "Thick Crust", "Cheese Crust");
        sauceChoiceBox.getItems().addAll("Tomato Sauce", "Pesto Sauce", "White Garlic Sauce");
        // Set default selection
        crustChoiceBox.getSelectionModel().selectFirst();
        sauceChoiceBox.getSelectionModel().selectFirst();
    }

    // // Example of a handler method for adding a crust. Adapt as necessary.
    // @FXML
    // private void handleAddCrust(ActionEvent event) {
    //     String selectedCrust = crustChoiceBox.getSelectionModel().getSelectedItem();
    //     System.out.println("Crust added: " + selectedCrust);
    //     // Implement your logic here (e.g., updating a model or view)
    // }

    // // Similar methods for other buttons and choice boxes...
    
    // @FXML
    // private void handleAddSauce(ActionEvent event) {
    //     String selectedSauce = sauceChoiceBox.getSelectionModel().getSelectedItem();
    //     System.out.println("Sauce added: " + selectedSauce);
    //     // Implement your logic here
    // }
    
    // @FXML
    // private void handleAddPizza(ActionEvent event) {
    //     // Implement your logic for adding a pizza with selected options
    //     System.out.println("Pizza added to order.");
    // }
    
    // @FXML
    // private void handleCheckout(ActionEvent event) {
    //     // Implement your logic for checking out
    //     System.out.println("Proceeding to checkout...");
    // }

    // // Add methods for handling topping selections and any other interactions
}
