package com.pizzaburger.pizza;

import com.pizzaburger.pizza.crust.*;
import com.pizzaburger.pizza.sauce.*;
import com.pizzaburger.pizza.topping.*;

import java.util.HashMap;
import java.util.Map;

public class PizzaMappings {
    public static final Map<String, PizzaCrust> crustMapping = new HashMap<>();
    public static final Map<String, PizzaSauce> sauceMapping = new HashMap<>();
    public static final Map<String, PizzaTopping> toppingMapping = new HashMap<>();

    static {
      // Crust mappings
      crustMapping.put("Thin Crust", new ThinCrust());
      crustMapping.put("Thick Crust", new ThickCrust());
      crustMapping.put("Cheese Crust", new CheeseCrust());
  
      // Sauce mappings
      sauceMapping.put("Tomato Sauce", new TomatoSauce());
      sauceMapping.put("Alfredo Sauce", new AlfredoSauce());
      sauceMapping.put("White Garlic Sauce", new WhiteGarlicSauce());
  
      // Topping mappings
      toppingMapping.put("Sausage", new SausageTopping());
      toppingMapping.put("Pepperoni", new PepperoniTopping());
      toppingMapping.put("Asiago", new AsiagoTopping());
      toppingMapping.put("Mozzarella", new MozzarellaTopping());
      toppingMapping.put("Pepper", new PepperTopping());
      toppingMapping.put("Mushroom", new MushroomTopping());
  }
}
