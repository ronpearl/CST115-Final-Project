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
	
	//replicate an existing Snack object
	public Snack(Snack snack) {
		super(snack.getName(), snack.getPrice(), snack.getQuantity(), snack.getProductId());
		this.calories = snack.getCalories();
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
		return super.toString() + ", Calroies: " + calories;
	}

}