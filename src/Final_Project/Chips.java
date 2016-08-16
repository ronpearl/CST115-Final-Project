package Final_Project;

public class Chips extends Snack {

	protected String name;
	
	//no-arg constructor
	public Chips(){
		
	}
	
	public Chips(String name){
		this.name = name;
	}
	
	public Chips(Chips chips){
		this.name = chips.getName();
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
	public String toString(){
		return "Name: " + this.name;
	}
}
