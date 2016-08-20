/*******************************************************
*                      Drink	                       *
*------------------------------------------------------*
* -ounces: int                                         *
*------------------------------------------------------*   
* +toString(): toString 							   *
* +Drink()						                       *
* +Drink(productName: String, price:double,            *
* quantity:int, dispenseLocation: String,              *
* productId: int, ounces: int)						   *
* +setOunces(ounces: int): void 			     	   *
* +getOunces(): int             			     	   *
********************************************************/

package Final_Project;

public class Drink extends Product {

	private int ounces;
	
	//no-arg constructor
	public Drink(){
		
	}
	
	public Drink(String productName, double price, int quantity, String dispenseLocation, int productId, int ounces) {
		super(productName, price, quantity, dispenseLocation, productId);
		this.ounces = ounces;
	}
	
	//replicate an existing Drink object
	public Drink(Drink drink){
		super(drink.getName(), drink.getPrice(), drink.getQuantity(), drink.getDispenseLocation(), drink.getProductId());
		this.ounces = drink.getOunces();
	}
	
	//setters
	public void setOunces(int ounces){
		this.ounces = ounces;
	}
	
	//getters
	public int getOunces(){
		return ounces;
	}
	
	@Override
	public String toString(){
		return super.toString() + ", Ounces: " + ounces;
	}
	
}