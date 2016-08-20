/*******************************************************
*                      GUM   	                       *
*------------------------------------------------------*
* -packSize: String                                    *
* -sugarFree: boolean                                  *
*------------------------------------------------------*   
* +Gum()								               *     
* +Gum(productName: String, price:double,              *
* quantity:int, dispenseLocation: String,              *
* productId: int, calories: int, packSize: String,     * 
* sugarFree: boolean)                                  *
* +Gum(Gum: gum)                                       *
* +setPackSize(packSize: String): void                 *
* +setSugarFree(sugarFree: boolean): void              *
* +getPackSize(): String   				               *
* +getSugarFree(): boolean       				       *
* +toString(): toString 							   *
********************************************************/

package Final_Project;

public class Gum extends Snack {

	private String packSize; //small, medium or large packaging
	private boolean sugarFree; //true = sugar free
	
	//no-arg constructor
	public Gum(){
		
	}
	
	public Gum(String productName, double price, int quantity, String dispenseLocation, int productId, int calories, String packSize, boolean sugarFree){
		super(productName, price, quantity, dispenseLocation, productId, calories);
		this.packSize = packSize;
		this.sugarFree = sugarFree;
	}
	
	public Gum(Gum gum){
		super(gum.getName(), gum.getPrice(), gum.getQuantity(), gum.getDispenseLocation(), gum.getProductId(), gum.getCalories());
		this.packSize = gum.getPackSize();
		this.sugarFree = gum.getSugarFree();
	}
	
	//setter methods
	public void setPackSize(String packSize){
		this.packSize = packSize;
	}
	
	public void setSugarFree(boolean sugarFree){
		this.sugarFree = sugarFree;
	}
	
	//getter methods
	public String getPackSize(){
		return this.packSize;
	}
	
	public boolean getSugarFree(){
		return this.sugarFree;
	}
	
	@Override
	public String toString(){
		return super.toString() + " Pack Size: " + this.packSize + ", Sugar Free: " + this.sugarFree;
	}
}
