/**
 * 	Program:	Vending Machine
 * 	Authors:	Ronald Pearl, Aaron Fonseca, Kris Hayes
 * 	Summary:	Final Project for CST-115 class
 * 	Date:		8/8/16 - 9/25/16
 * 	Description:
 * 		You will create an application that models a vending machine. The vending machine 
 * 		will have two types of users – a customer, who will be able to select a product, 
 * 		and a BOSS, who will be able to maintain the collection of products in the machine.  
 * 		The machine itself will have a graphical interface that displays the available 
 * 		products and allows the user to make selections. The BOSS will have a separate 
 * 		interface that provides a variety of maintenance options.  The machine will 
 * 		provide a means of alternating between the two types of users.
 */

package Final_Project;

public class VendingMachine {
	public static void main(String[] args) {
		Dispenser testDisp = new Dispenser();
		
		//add 5 products to the Dispenser
		testDisp.addProduct(new Chips("Doritos", 1.99, 1, "A2", 1234, 135, false));
		testDisp.addProduct(new Chips("Cheetos", 2.49, 5, "B3", 1155, 155, false));
		testDisp.addProduct(new Candy("Reeses", 2.09, 3, "C1", 2435, 240, 1));
		testDisp.addProduct(new Gum("Trident", 0.89, 5, "D4", 9999, 5, "Medium", true));
		testDisp.addProduct(new Drink("Coke", 1.49, 4, "A1", 1111, 12));
		testDisp.addProduct(new Drink("Tea", 1.25, 3, "A3", 1133, 12));
	
		// Create new Drinks to Compare
		Drink tea = new Drink("Tea", 1.25, 3, "A3", 1133, 12);
		Drink coke = new Drink("Coke", 1.49, 4, "A1", 1111, 12);
		coke.compareTo(tea);
				
	    //display Products in a String
		System.out.println(testDisp.getProductsToString() + "\n" +
				"Total Product Count: " + testDisp.getTotalProductCount());
		
		// Result of Drinks Compare
		int result = coke.compareTo(tea);
		if (result < 0){
			System.out.print("Coke is less than tea");
		} else if (result == 0){
			System.out.print("These are the same");
		}else {
			System.out.print("Coke is greater than tea");
		}
		
	}
	
}