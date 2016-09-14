package Final_Project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class Global_InventoryManagement extends Product {
	
	ArrayList<Product> vendMachine1 = new ArrayList<Product>();
	ArrayList<Product> vendMachine2 = new ArrayList<Product>();
	
	Global_InventoryManagement() {
		
	}
	
	/**
	 * csvInventoryImport()
	 * 
	 * NOTE:  
	 * 		Currently we are assuming that we only have 2 vending machines to track for simplicity.
	 * 
	 * Imports inventory from CSV file
	 * @throws IOException 
	 */
	public void csvInventoryImport(Dispenser mainDisp, Dispenser dispenser2) throws IOException {
		
		// Attempt to read inventory from file
		try {
			
			CSVReader inventory1 = new CSVReader(new FileReader("inventory_1.csv"), ',', '"', 1);
			CSVReader inventory2 = new CSVReader(new FileReader("inventory_2.csv"), ',', '"', 1);
			
			// Save entries for each into lists
			List<String[]> inventory1List = inventory1.readAll();
			List<String[]> inventory2List = inventory2.readAll();
			
			for (int i = 0; i < inventory1List.size(); i++) {
				// Create Product objects and add them to first vending machine
				switch (inventory1List.get(i)[0]) {
					case "Candy":
						addCandy(mainDisp, inventory1List.get(i));
						break;
					case "Chips":
						addChips(mainDisp, inventory1List.get(i));
						break;
					case "Drink":
						addDrink(mainDisp, inventory1List.get(i));
						break;
					case "Gum":
						addGum(mainDisp, inventory1List.get(i));
						break;
					default:
						// Type does not exist
						break;
				}
				
//				System.out.print(inventory1List.get(i)[0] + " : "); // Product Type
//				System.out.print(inventory1List.get(i)[1] + " : "); // ID
//				System.out.print(inventory1List.get(i)[2] + " : "); // Name
//				System.out.print(inventory1List.get(i)[3] + " : "); // Price
//				System.out.print(inventory1List.get(i)[4] + " : "); // Qty
//				System.out.print(inventory1List.get(i)[5] + " : "); // Location
//				System.out.print(inventory1List.get(i)[6] + " : "); // Desc
//				System.out.print(inventory1List.get(i)[7] + " : "); // Calories
//				System.out.print(inventory1List.get(i)[8] + " : "); // Serving Size
//				System.out.print(inventory1List.get(i)[9] + " : "); // Ounces
//				System.out.print(inventory1List.get(i)[10] + " : "); // Baked?
//				System.out.print(inventory1List.get(i)[11] + " : "); // Pack Size
//				System.out.println(inventory1List.get(i)[12] + " : "); // Sugarfree?
			}
			
			for (int i = 0; i < inventory2List.size(); i++) {
				// Create Product objects and add them to first vending machine
				switch (inventory2List.get(i)[0]) {
					case "Candy":
						addCandy(dispenser2, inventory2List.get(i));
						break;
					case "Chips":
						addChips(dispenser2, inventory2List.get(i));
						break;
					case "Drink":
						addDrink(dispenser2, inventory2List.get(i));
						break;
					case "Gum":
						addGum(dispenser2, inventory2List.get(i));
						break;
					default:
						// Type does not exist
						break;
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * addCandy()
	 * 
	 * @param dispenser
	 * @param prod
	 */
	public void addCandy(Dispenser dispenser, String[] prod) {
		dispenser.addProduct(new Candy(
			prod[2], 
			Double.parseDouble(prod[3]), 
			Integer.parseInt(prod[4]), 
			prod[5], 
			Integer.parseInt(prod[1]), 
			prod[6], 
			Integer.parseInt(prod[7]), 
			Double.parseDouble(prod[8])));
	}
	
	/**
	 * addChips()
	 * 
	 * @param dispenser
	 * @param prod
	 */
	public void addChips(Dispenser dispenser, String[] prod) {
		dispenser.addProduct(new Chips(
			prod[2], 
			Double.parseDouble(prod[3]), 
			Integer.parseInt(prod[4]), 
			prod[5], 
			Integer.parseInt(prod[1]), 
			prod[6], 
			Integer.parseInt(prod[7]), 
			Boolean.parseBoolean(prod[10])));
	}
	
	/**
	 * addDrink()
	 * 
	 * @param dispenser
	 * @param prod
	 */
	public void addDrink(Dispenser dispenser, String[] prod) {
		dispenser.addProduct(new Drink(
			prod[2], 
			Double.parseDouble(prod[3]), 
			Integer.parseInt(prod[4]), 
			prod[5], 
			Integer.parseInt(prod[1]), 
			prod[6], 
			Integer.parseInt(prod[9])));
	}
	
	/**
	 * addGum()
	 * 
	 * @param dispenser
	 * @param prod
	 */
	public void addGum(Dispenser dispenser, String[] prod) {
		dispenser.addProduct(new Gum(
			prod[2], 
			Double.parseDouble(prod[3]), 
			Integer.parseInt(prod[4]), 
			prod[5], 
			Integer.parseInt(prod[1]), 
			prod[6], 
			Integer.parseInt(prod[7]), 
			prod[11],
			Boolean.parseBoolean(prod[12])));
	}
}