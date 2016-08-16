package Final_Project;

public class Gum extends Snack {

	private String packSize; //small, medium or large packaging
	private boolean sugarFree; //true = sugar free
	
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
		return packSize;
	}
	
	public boolean getSugarFree(){
		return sugarFree;
	}
	
	@Override
	public String toString(){
		
	}
}
