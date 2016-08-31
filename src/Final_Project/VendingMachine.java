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

import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos; 
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VendingMachine extends Application {
	GridPane mainCategoryPane = new GridPane();
	Dispenser mainDisp = new Dispenser();
	
	@Override
	public void start(Stage primaryStage) {		
		// Add initial products to the Dispenser
		// For identification purposes, Product ID's should have a specific starting number:
		// 	Candy:	1
		// 	Chips:	2
		// 	Drink:	3
		// 	Gum:	4
		mainDisp.addProduct(new Chips("Doritos", 1.99, 1, "A2", 2234, "Description", 135, false));
		mainDisp.addProduct(new Chips("Cheetos", 2.49, 5, "B3", 2155, "Description", 155, false));
		mainDisp.addProduct(new Candy("Reeses", 2.09, 3, "C1", 1435, "Description", 240, 1));
		mainDisp.addProduct(new Gum("Trident", 0.89, 5, "D4", 4999, "Description", 5, "Medium", true));
		mainDisp.addProduct(new Drink("Coke", 1.49, 4, "A1", 3111, "Description", 12));
		mainDisp.addProduct(new Drink("Tea", 1.25, 3, "A3", 3133, "Description", 12));
		
		// Create GridPane
		createCategoryPane();
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(mainCategoryPane);
		primaryStage.setTitle("Grid Pane Example"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	/**
	 * createCategoryPane()
	 * 
	 */
	public void createCategoryPane() {
		// Clear the grid
		mainCategoryPane.getChildren().clear();
		
		mainCategoryPane.setAlignment(Pos.CENTER);
		mainCategoryPane.setPadding(new Insets(10, 10, 10, 10));
		mainCategoryPane.setHgap(8);
		mainCategoryPane.setVgap(8);
		
		String categories[] = {"Candy", "Chips", "Drink", "Gum"};
		
		// Setup rows and columns to define the layout
		int row = 0;
		int col = 0;
		
		// Add panes to the grid
		for (int i = 0; i < categories.length; i++) {
			mainCategoryPane.add(new buildCategory(categories[i]), col, row);
			
			col++;
			
			if (col == 2) {	// Maximum columns will be 2. Once this is met, reset column and increment to next row
				col = 0;
				row++;
			}
		}
	}
	
	/**
	 * buildCategory()
	 */
	class buildCategory extends GridPane {
		buildCategory(String catName) {
			// Setup internal GridPane
			GridPane pane2 = new GridPane();
			pane2.setAlignment(Pos.CENTER);
			pane2.setPadding(new Insets(10, 10, 10, 10));
			pane2.setHgap(8);
			pane2.setVgap(8);
			
			// Add to parent GridPane
			getChildren().add(pane2);
			
			// Create parts
			Button catButton = new Button("Buy " + catName);		
			catButton.setOnAction(value ->  {
				viewCategoryItems(catName);
			});
			
			Image catImage = new Image(new File("images/" + catName.toLowerCase() + ".jpg").toURI().toString());
			
			// Add items to the pane
			pane2.add(new ImageView(catImage), 0, 0);
			pane2.add(catButton, 0, 1);
			pane2.setHalignment(catButton, HPos.CENTER);
		}
	}
	
	/**
	 * viewCategoryItems()
	 * 
	 * @param catName
	 */
	public void viewCategoryItems(String catName) {
		// Clear the grid
		mainCategoryPane.getChildren().clear();
		
		// Get all items in this category
		ArrayList<Product> allProds = mainDisp.getProducts();
		
		// Setup ArrayList to hold products in this category
		ArrayList<Product> prodsInThisCat = new ArrayList();
		
		for (int i = 0; i < allProds.size(); i++) {
			int currentProdId = allProds.get(i).getProductId();
			int lookingForID = 0;
			
			switch (catName) {
				case "Candy":
					lookingForID = 1;
					break;
				case "Chips":
					lookingForID = 2;
					break;
				case "Drink":
					lookingForID = 3;
					break;
				case "Gum":
					lookingForID = 4;
					break;
			}
			
			// Get the first number in the product id
			while (currentProdId >= 10) {
				currentProdId /= 10;
			}
			
			// If the first number matches the ID we are looking for, 
			// then add it to our new ArrayList
			if (currentProdId == lookingForID) {
				prodsInThisCat.add(allProds.get(i));
			}
		}
		
		// Now we need to build the pane and list out the items in this category
		buildCategoryItems(prodsInThisCat);
	}
	
	
	
	public void buildCategoryItems(ArrayList prodsInThisCat) {
		mainCategoryPane.setAlignment(Pos.CENTER);
		mainCategoryPane.setPadding(new Insets(10, 10, 10, 10));
		mainCategoryPane.setHgap(8);
		mainCategoryPane.setVgap(8);
		
		Button backBtn = new Button("Back To Categories");		
		backBtn.setOnAction(value ->  {
			createCategoryPane();
		});
		
		mainCategoryPane.add(backBtn, 0, 1);
		mainCategoryPane.setHalignment(backBtn, HPos.CENTER);
		
		// Setup rows and columns to define the layout
		int row = 0;
		int col = 0;
		
		for (int i = 0; i < prodsInThisCat.size(); i++) {
			mainCategoryPane.add(new buildCategoryItems((Product) prodsInThisCat.get(i)), col, row);
			
			col++;
			
			if (col == 2) {	// Maximum columns will be 2. Once this is met, reset column and increment to next row
				col = 0;
				row++;
			}
		}
	}
	
	

	class buildCategoryItems extends GridPane {
		buildCategoryItems(Product prod) {
			// Setup internal GridPane
			GridPane pane2 = new GridPane();
			pane2.setAlignment(Pos.CENTER);
			pane2.setPadding(new Insets(10, 10, 10, 10));
			pane2.setHgap(8);
			pane2.setVgap(8);
			
			// Add to parent GridPane
			getChildren().add(pane2);
			
			// Create parts
			pane2.add(new Label(prod.getName()), 0, 0);
			
			
			
//			Image catImage = new Image(new File("images/" + catName.toLowerCase() + ".jpg").toURI().toString());
//			
//			// Add items to the pane
//			pane2.add(new ImageView(catImage), 0, 0);
//			pane2.add(catButton, 0, 1);
//			pane2.setHalignment(catButton, HPos.CENTER);
		}
	}
	
	
//	public static void main(String[] args) {
//		Dispenser testDisp = new Dispenser();
//		
//		//add 5 products to the Dispenser
//		testDisp.addProduct(new Chips("Doritos", 1.99, 1, "A2", 1234, 135, false));
//		testDisp.addProduct(new Chips("Cheetos", 2.49, 5, "B3", 1155, 155, false));
//		testDisp.addProduct(new Candy("Reeses", 2.09, 3, "C1", 2435, 240, 1));
//		testDisp.addProduct(new Gum("Trident", 0.89, 5, "D4", 9999, 5, "Medium", true));
//		testDisp.addProduct(new Drink("Coke", 1.49, 4, "A1", 1111, 12));
//		testDisp.addProduct(new Drink("Tea", 1.25, 3, "A3", 1133, 12));
//	
//		// Create new Drinks to Compare
//		Drink tea = new Drink("Tea", 1.25, 3, "A3", 1133, 12);
//		Drink coke = new Drink("Coke", 1.49, 4, "A1", 1111, 12);
//		coke.compareTo(tea);
//				
//	    //display Products in a String
//		System.out.println(testDisp.getProductsToString() + "\n" +
//				"Total Product Count: " + testDisp.getTotalProductCount());
//		
//		// Result of Drinks Compare
//		int result = coke.compareTo(tea);
//		if (result < 0){
//			System.out.print("Coke is less than tea");
//		} else if (result == 0){
//			System.out.print("These are the same");
//		}else {
//			System.out.print("Coke is greater than tea");
//		}
//		
//	}
	
}