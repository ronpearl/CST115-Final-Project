package Final_Project;

public abstract class Snack extends Product {
	
	protected int calories;
	
	//no-arg constructor
	public Snack() {
		
	}
	
	public Snack(String productName, double price, int quantity, int productId, int calories) {
		super(productName, price, quantity, productId);
		this.calories = calories;
	}
	
	public Snack(Snack snack) {
		
	}
	
	// Setters
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	// Getters
	public int getCalories() {
		return this.calories;
	}
	
	@Override
	public String toString() {
		return "";
	}

}