package com.pizzaburger.menuitem;

/**
 * MenuItem represents any object that can go on a menu, i.e., it has a descriptive name and a price.
 */
public interface MenuItem {
	public String toNiceString();
	public Double getPrice(); 
}
