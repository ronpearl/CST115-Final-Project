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
		testDisp.addProduct(new Chips("Doritos", 1.99, 1, 1234, 135, false));
		testDisp.addProduct(new Chips("Cheetos", 2.49, 1, 1155, 155, false));
		testDisp.addProduct(new Candy("Reeses", 2.09, 1, 2435, 240, 1));
		testDisp.addProduct(new Gum("Trident", 0.89, 1, 9999, 5, "Medium", true));
		testDisp.addProduct(new Drink("Coke", 1.49, 1, 1111, 12));
				
		//display Products in a String
		System.out.print(testDisp.getProducts());
		
	}
}
