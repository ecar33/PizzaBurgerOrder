module com.pizzaburger {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.pizzaburger to javafx.fxml;
    exports com.pizzaburger;
}
