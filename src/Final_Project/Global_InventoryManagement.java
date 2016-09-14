package Final_Project;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.opencsv.CSVReader;

public class Global_InventoryManagement extends Product {
	
	Global_InventoryManagement() {
		csvInventoryImport();
	}
	
	/**
	 * csvInventoryImport()
	 * 
	 * Imports inventory from CSV file
	 */
	public void csvInventoryImport() {
		// Attempt to read inventory from file
		try {
			CSVReader reader = new CSVReader(new FileReader("inventory.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}