package pizza.crust;
import pizza.AbstractMenuItem;

/**
 * {@code PizzaTopping} represents all possible pizza crusts
 */
public abstract class PizzaCrust extends AbstractMenuItem {
	/**
	 * {@code ingedient} represents the base ingredient for the crust.
	 * For this project, we use a string rather than adding a class hierarchy of ingredients.
	 */
	protected String ingredient;
	
	public abstract String toString(); 
	
	/**
	 * For pizza crusts, output the ingredient in addition to the type.
	 */
	public String toNiceString() {
		return "Crust is: " + toString() + " (" + ingredient + ")";
	}

	public String getIngredient() {
		return this.ingredient;
	}
	
	public void setIngredient(String ing) {
		this.ingredient = ing;
	}
	
	/**
	 * Provides instructions/warning (if applicable) for handling the pizza based on crust.
	 * @return empty string by default unless specific instructions are needed.
	 */
	public String checkIntegrity() {
		return "";
	}
	
	public Double getPrice() {
		return 0.75; // default price for crust
	}
}
