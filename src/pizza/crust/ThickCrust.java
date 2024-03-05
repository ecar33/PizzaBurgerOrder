package pizza.crust;

/**
 * {@code ThickCrust} represents thick pizza crusts.
 */
public class ThickCrust extends PizzaCrust {
	/**
	 * Thick crust pizza has a deep dish option.
	 */
	private Boolean isDeepDish;
	
	@Override
	public String toString() {
		return "Thick Crust";
	}
	
	public Boolean getIsDeepDish() {
		return isDeepDish;
	}
	
	public void setIsDeepDish(Boolean deep) {
		this.isDeepDish = deep;
	}
	
	@Override
	public String toNiceString() {
		return super.toNiceString() + (isDeepDish? " (Deep Dish)": "");
	}	
	
	/**
	 * Cauliflower crusts may fall apart if not handled carefully, especially for thick crusts.
	 */
	@Override
	public String checkIntegrity() {
		return ingredient.equals("Cauliflower")? "Handle carefully - thick cauliflower crusts might fall apart." : "";
	}

	@Override
	public Double getPrice() {
		return 1.20; 
	}

}
