# PizzaBurger Order App

The PizzaBurger Order App allows users to customize and order their pizzas and burgers from a desktop interface. With an intuitive design, customers can select their preferred crusts, sauces, toppings for pizzas, and buns, meats, cheeses, and garnishes for burgers. The app tracks your order in a shopping cart and provides a detailed receipt upon completion.

## Features

- **Custom Pizza and Burger Orders**: Choose from a variety of crusts, sauces, toppings for pizzas, and buns, meats, cheeses, garnishes for burgers.
- **Dynamic Cart**: Review your selections and total cost in a dynamically updated cart.
- **Receipt Generation**: Get a detailed receipt of your order with itemized prices and a total amount.

## Getting Started

### Prerequisites

- Java 8 or later.
- JavaFX SDK.
- An IDE such as IntelliJ IDEA, Eclipse, or NetBeans.

### Installation

1. Clone the repository to your local machine.
    ```bash
    git clone https://github.com/yourusername/pizzaburger-app.git
    ```
2. Open the project in your IDE.
3. Ensure the JavaFX library is correctly configured in your project settings.
4. Build and run the application.

## Usage

- **Start the Application**: Launch the PizzaBurger Order App by navigating to the `pizzaburger` folder within the repo and typing:
    ```bash
    mvn clean javafx:run
    ```
- **Customize Your Order**:
  - Select the **Add a Pizza** or **Add a Burger** buttons to start customizing.
  - Choose your desired crust/bun, sauce, and toppings/garnishes. The UI updates dynamically with each selection.
  - Click **Add to Cart** to add your customized item to the order.
  - Click **Restart** to undo selections.

- **Review Your Cart**:
  - Navigate to the **View Cart** to review your selections.
  - You can checkout or add more items to your cart.

- **Complete Your Order**:
  - Once satisfied with your selections, proceed to generate a receipt by clicking on **Checkout** in your shopping cart.
  - The receipt provides a detailed, sorted itemization and the total cost of your order.

- **New Order**:
  - To start a new order, click on **Start a new order** from the receipt page.

