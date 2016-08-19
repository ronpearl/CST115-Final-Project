package Final_Project;

public class Candy extends Snack {
	
	private double servingSize; //how many servings per candy
	
	//no-arg constructor
	public Candy() {
		
	}
	
	public Candy(String productName, double price, int quantity, String dispenseLocation, int productId, int calories, double servingSize) {
		super(productName, price, quantity, dispenseLocation, productId, calories);
		this.servingSize = servingSize;
	}
	
	//replicate an existing Candy object
	public Candy(Candy candy) {
		super(candy.getName(), candy.getPrice(), candy.getQuantity(), candy.getDispenseLocation(), candy.getProductId(), candy.getCalories());
		this.servingSize = candy.getServingSize();		
	}
	
	// Setters
	public void setServingSize(double servingSize){
		this.servingSize = servingSize;
	}
	// Getters
	public double getServingSize(){
		return servingSize;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Serving Size: " + servingSize;
	}
	

}