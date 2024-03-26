package com.pizzaburger.menuitem;

/**
 * Represents any object that can go on a menu. 
 * This includes any items that have a descriptive name and a price.
 */
public interface MenuItem {
    
    /**
     * Generates a nicely formatted string representing the menu item.
     * 
     * @return A descriptive string of the menu item.
     */
    public String toNiceString();
    
    /**
     * Gets the price of the menu item.
     * 
     * @return The price of the menu item.
     */
    public Double getPrice(); 
}