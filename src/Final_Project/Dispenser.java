/*******************************************************
*                      Dispenser                       *
*------------------------------------------------------*
* -inventoryCount: int                                 *
* -objCount: int                                       *
* -objType: String[]                                   *
* -location: String                                    *
* -balance: float                                      *  
* -moneyInMachine: float                               *      
* -status: String                                      *
* -transaction: String[]							   *
* -transactions:ArrayList<transaction>                 *
*------------------------------------------------------*        
* +addProduct()                                        *
* +setProduct()                                        *
* +removeProduct()                                     *
* +dispenseProduct()                                   *
********************************************************/

package Final_Project;

import java.util.ArrayList;

public class Dispenser {

		private ArrayList<Product> products = new ArrayList();
		private int maxProducts = 40;
		private int inventoryCount; // Number of Product Objects in vending machine
		private int objCount; // Number of Specific product in vending machine
		private String[] objType = new String[20]; // Type of product in vending machine
		private String[] location = new String[40]; // Location of product 40 spots (e.g. E8)
		private float balance; // Amount of money for transaction
		private float moneyInMachine; // Amount of money in vending machine
		private String status; // Status of vending machine
		private String[] transaction; // Record of current transaction
//		private ArrayList<transaction> transactions; // Records of all of the transactions on vending machine 

		//no-arg constructor
		Dispenser(){
			
		}
		
		Dispenser(ArrayList<Product> products){
			this.products = products;
		}
		
		/**
		 * addProduct()
		 * 
		 * Adds a product object to the dispenser
		 * 
		 * @param product
		 */
		public void addProduct(Product product){
			// Check if dispenser is full
			if (dispenserFull()) {
				System.out.println("Dispenser is full. Maximum number of products is " + maxProducts);
			} else {
				// Add it to the ArrayList
				products.add(product);
			}
		}
		
		/**
		 * removeProduct()
		 * 
		 * Remove Product from product ArrayList
		 * 
		 * @param id
		 */
		public void removeProduct(int id) {
			for (int i = 0; i < products.size(); i++) {
				if (products.get(i).getProductId() == id) {
					products.remove(i);
				}
			}
			
			// TODO: MAY also need to update inventory counts, dispenser views, etc... depending on how this is implemented
		}
		
		/**
		 * dispenserFull()
		 * 
		 * Checks the maximum product count in the dispenser.
		 * 
		 * @return boolean
		 */
		public boolean dispenserFull() {
			boolean tempResult = false;
			
			if (products.size() >= maxProducts)
				tempResult = true;
			
			return tempResult;
		}

		// Setters
		public void setMaxProducts(int max) {
			this.maxProducts = max;
		}
		
		// Set Product to location
//		public setProduct(){
//
//		}
//
//		// Dispense Product from Dispenser
//		public dispenseProduct(){
//
//		}
		
		// Getters
		public String getProducts(){
			String tempProds = "";
			
			for(int i = 0; i < products.size(); i++){
				tempProds += products.get(i).toString() + "\n";
			}
			
			return tempProds;
		}
	
}
