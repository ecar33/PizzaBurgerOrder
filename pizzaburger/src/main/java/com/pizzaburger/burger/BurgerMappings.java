package com.pizzaburger.burger;

import com.pizzaburger.burger.bun.*;
import com.pizzaburger.burger.sauce.*;
import com.pizzaburger.burger.topping.*;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code BurgerMappings} class defines mappings between string identifiers
 * and specific implementations of {@code BurgerBun}, {@code BurgerSauce}, and
 * {@code BurgerTopping}. These mappings facilitate the creation and
 * customization
 * of burgers based on string input, enabling dynamic burger composition based
 * on user selections or predefined configurations.
 */
public class BurgerMappings {
    /**
     * Maps string identifiers to {@code BurgerBun} implementations.
     */
    public static final Map<String, BurgerBun> bunMapping = new HashMap<>();

    /**
     * Maps string identifiers to {@code BurgerSauce} implementations.
     */
    public static final Map<String, BurgerSauce> sauceMapping = new HashMap<>();

    /**
     * Maps string identifiers to {@code BurgerTopping} implementations.
     */
    public static final Map<String, BurgerTopping> toppingMapping = new HashMap<>();

    static {
        // Initialize bun mappings
        bunMapping.put("Sesame Seed", new SesameSeedBun());
        bunMapping.put("Classic", new ClassicBun());
        bunMapping.put("Pretzel Bun", new PretzelBun());

        // Initialize sauce mappings
        sauceMapping.put("Ketchup", new KetchupSauce());
        sauceMapping.put("Spicy Mayo", new SpicyMayoSauce());
        sauceMapping.put("Mustard", new MustardSauce());

        // Initialize topping mappings
        toppingMapping.put("Cheddar", new CheddarTopping());
        toppingMapping.put("Pepperjack", new PepperjackTopping());
        toppingMapping.put("Bacon", new BaconTopping());
        toppingMapping.put("Patty", new PattyTopping());
        toppingMapping.put("Lettuce", new LettuceTopping());
        toppingMapping.put("Tomato", new TomatoTopping());
    }
}