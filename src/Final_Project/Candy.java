package Final_Project;

public class Candy extends Snack {
	
	protected String name;
	
	//no-arg constructor
	public Candy() {
		
	}
	
	public Candy(String name) {
		this.name = name;
	}
	
	public Candy(Candy candy) {
		this.name = candy.getName();
	}
	
	// Setters
	public void setName(String name) {
		this.name = name;
	}
	
	// Getters
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "Name: " + this.name;
	}
	

}
