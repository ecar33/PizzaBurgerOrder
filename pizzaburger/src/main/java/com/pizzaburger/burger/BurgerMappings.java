package com.pizzaburger.burger;

import com.pizzaburger.burger.bun.*;
import com.pizzaburger.burger.sauce.*;
import com.pizzaburger.burger.topping.*;

import java.util.HashMap;
import java.util.Map;

public class BurgerMappings {
    public static final Map<String, BurgerBun> bunMapping = new HashMap<>();
    public static final Map<String, BurgerSauce> sauceMapping = new HashMap<>();
    public static final Map<String, BurgerTopping> toppingMapping = new HashMap<>();

    static {
        // Bun mappings
        bunMapping.put("Sesame Seed", new SesameSeedBun());
        bunMapping.put("Classic", new ClassicBun());
        bunMapping.put("Pretzel Bun", new PretzelBun());

        // Sauce mappings
        sauceMapping.put("Ketchup", new KetchupSauce());
        sauceMapping.put("Spicy Mayo", new SpicyMayoSauce());
        sauceMapping.put("Mustard", new MustardSauce());

        // Topping mappings
        toppingMapping.put("Cheddar", new CheddarTopping());
        toppingMapping.put("Pepperjack", new PepperjackTopping());
        toppingMapping.put("Bacon", new BaconTopping());
        toppingMapping.put("Patty", new PattyTopping());
        toppingMapping.put("Lettuce", new LettuceTopping());
        toppingMapping.put("Tomato", new TomatoTopping());
    }
}
