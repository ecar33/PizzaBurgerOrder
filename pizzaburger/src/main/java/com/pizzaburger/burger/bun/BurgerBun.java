package com.pizzaburger.burger.bun;
import com.pizzaburger.menuitem.AbstractMenuItem;

/**
 * {@code BurgerBun} represents all possible burger buns.
 * The specific type of bun is defined by subclasses.
 */
public abstract class BurgerBun extends AbstractMenuItem {

    // Abstract method toString is already declared in the Object class and should be implemented by all subclasses
    // to describe the bun, for example: "Whole Wheat Bun", "Gluten-Free Bun", etc.
    
    /**
     * Provides a nice string representation including details specific to the bun type.
     * This method assumes that subclasses will implement toString() to provide these details.
     * @return A descriptive string for the burger bun.
     */
    public String toNiceString() {
        // Assuming toString() is implemented by subclasses to return the bun type
        return "Bun: " + toString();
    }
    
    /**
     * Provides the price for the burger bun. Subclasses can override this method to specify a different price.
     * @return The price of the burger bun.
     */
    @Override
    public Double getPrice() {
        // Return a default price for a bun; subclasses can adjust this as necessary
        return 0.75; // Default price for a bun
    }
}