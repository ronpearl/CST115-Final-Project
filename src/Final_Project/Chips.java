package Final_Project;

public class Chips extends Snack {

	private boolean baked; //true if baked, false if fried
	
	//no-arg constructor
	public Chips(){
		
	}
	
	public Chips(String productName, double price, int quantity, String dispenseLocation, int productId, int calories, boolean baked){
		super(productName, price, quantity, dispenseLocation, productId, calories);
		this.baked = baked;		
	}
	
	public Chips(Chips chips){
		super(chips.getName(), chips.getPrice(), chips.getQuantity(), chips.getDispenseLocation(), chips.getProductId(), chips.getCalories());
		this.baked = chips.getBaked();
	}
	
	// Setters
	public void setBaked(boolean baked){
		this.baked = baked;
	}
	
	// Getters
	public boolean getBaked(){
		return baked;
	}
	
	@Override
	public String toString(){
		return super.toString() + ", Baked: " + baked;
	}
}
