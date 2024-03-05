package pizza;
import java.util.Scanner;

import pizza.crust.ThickCrust;
import pizza.crust.ThinCrust;
import pizza.sauce.AlfredoSauce;
import pizza.sauce.TomatoSauce;
import pizza.topping.AsiagoTopping;
import pizza.topping.MeatTopping;
import pizza.topping.MozzarellaTopping;
import pizza.topping.MushroomTopping;
import pizza.topping.PepperTopping;
import pizza.topping.PepperoniTopping;
import pizza.topping.SausageTopping;

/**
 * This is the driver class for assembling a pizza from crust, sauce and toppings
 */
public class PizzaMain {
	private Pizza pizza;
	private Scanner input;
	
	public PizzaMain() {
		pizza = new Pizza();
		input = new Scanner(System.in);
	}
	
	private void inputCrustChoice() {
		Boolean validChoice = false;
		System.out.println("What kind of crust would you like:");
		System.out.println("1 - Thin Crust");
		System.out.println("2 - Thick Crust");
		System.out.print("Your choice: ");
		while (!validChoice) {
			Integer choice = input.nextInt();
			switch(choice) {
				case 1: 
					pizza.setCrust(new ThinCrust());
					validChoice = true;
					break;
				case 2: 
					ThickCrust tc = new ThickCrust();
					System.out.print("Deep dish (Y/N)? ");
					String yn = input.next();
					if (yn.toUpperCase().substring(0,1).equals("Y")) {
						System.out.println("Deep dish! good choice!");
						tc.setIsDeepDish(true);
					} else {
						tc.setIsDeepDish(false);
					}
					pizza.setCrust(tc);
					validChoice = true;
					break;
				default:
					System.out.println("Pick between 1-2");
			}
		}
		
		System.out.println("Select dough type:");
		System.out.println("1 - Flour");
		System.out.println("2 - Cauliflower");
		System.out.print("Your choice: ");
		validChoice = false;
		while (!validChoice) {
			Integer choice = input.nextInt();
			switch(choice) {
				case 1: 
					pizza.getCrust().setIngredient("Flour");
					validChoice = true;
					break;
				case 2: 
					pizza.getCrust().setIngredient("Cauliflower");
					validChoice = true;
					break;
				default:
					System.out.println("Pick between 1-2");
			}
		}
	}

	private void inputSauceChoice() {
		Boolean validChoice = false;
		System.out.println("What kind of sauce would you like:");
		System.out.println("1 - Tomato Sauce");
		System.out.println("2 - Alfredo Sauce");
		System.out.print("Your choice: ");
		while (!validChoice) {
			Integer choice = input.nextInt();
			switch(choice) {
				case 1: 
					pizza.setSauce(new TomatoSauce());
					validChoice = true;
					break;
				case 2: 
					pizza.setSauce(new AlfredoSauce());
					validChoice = true;
					break;
				default:
					System.out.println("Pick between 1-2");
			}
		}
	}

	private MeatTopping getMeatToppingDetails(MeatTopping m) {
		Integer spiciness = 0;
		Boolean validChoice = false;
		while (!validChoice) {
			System.out.print("Spiciness level (1-10): ");
			spiciness = input.nextInt();
			if (spiciness >= 1 && spiciness <= 10) {
				m.setSpiciness(spiciness);
				validChoice = true;
			}
		}
		return m;
	}
	
	private void inputToppingChoices() {
		System.out.print("How many toppings? ");
		Integer numToppings = input.nextInt();
		for (Integer i = 0; i < numToppings; i++) {
			Boolean validChoice = false;
			System.out.println("1 - Pepperoni");
			System.out.println("2 - Sausage");
			System.out.println("3 - Pepper");
			System.out.println("4 - Mushroom");
			System.out.println("5 - Mozzarella");
			System.out.println("6 - Asiago");
			System.out.print("Your choice: ");
			while (!validChoice) {
				Integer choice = input.nextInt();
				switch(choice) {
					case 1: 
						pizza.addTopping(getMeatToppingDetails(new PepperoniTopping()));
						validChoice = true;
						break;
					case 2: 
						pizza.addTopping(getMeatToppingDetails(new SausageTopping()));
						validChoice = true;
						break;
					case 3: 
						pizza.addTopping(new PepperTopping());
						validChoice = true;
						break;
					case 4: 
						pizza.addTopping(new MushroomTopping());
						validChoice = true;
						break;
					case 5: 
						pizza.addTopping(new MozzarellaTopping());
						validChoice = true;
						break;
					case 6: 
						pizza.addTopping(new AsiagoTopping());
						validChoice = true;
						break;
					default:
						System.out.println("Pick between 1-6");
				}
			}
		}
	}
	
	private void showPizza() {
		pizza.displaySorted();
		System.out.println(pizza.getCrust().checkIntegrity());
		System.out.println("----");
		System.out.printf("%s $%.2f\n", pizza.toNiceString(), pizza.getPrice());
	}
	
	/**
	 * Solicit user inputs regarding pizza preferences
	 */
	public void runMenu() {
		inputCrustChoice();
		inputSauceChoice();
		inputToppingChoices();
		showPizza();
	}
	
	public static void main(String[] args) {
		PizzaMain pm = new PizzaMain();
		pm.runMenu();
	}
}
