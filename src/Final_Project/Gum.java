package Final_Project;

public class Gum extends Snack {

	protected String packSize; //small, medium or large packaging
	protected boolean sugarFree; //true = sugar free
	
	//no-arg constructor
	public Gum(){
		
	}
	
	public Gum(String packSize, boolean sugarFree){
		this.packSize = packSize;
		this.sugarFree = sugarFree;
	}
	
	public Gum(Gum gum){
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
		return "Pack Size: " + this.packSize + ", Sugar Free: " + this.sugarFree;
	}
}
