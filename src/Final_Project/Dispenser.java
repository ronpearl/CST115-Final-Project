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

		private int inventoryCount; // Number of Product Objects in vending machine
		private int objCount; // Number of Specific product in vending machine
		private String[] objType = new String[20]; // Type of product in vending machine
		private String[] location = new String[40]; // Location of product 40 spots (e.g. E8)
		private float balance; // Amount of money for transaction
		private float moneyInMachine; // Amount of money in vending machine
		private String status; // Status of vending machine
		private String[] transaction; // Record of current transaction
		private ArrayList<transaction> transactions; // Records of all of the transactions on vending machine 


		// Add Product to Dispenser
		public addProduct(){

		}

		// Set Product to location
		public setProduct(){

		}

		// Remove Product from Dispenser
		public removeProduct(){

		}

		// Dispense Product from Dispenser
		public dispenseProduct(){

		}
	
}
