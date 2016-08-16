/*******************************************************
*                      Product	                       *
*------------------------------------------------------*
* -productName: String                                 *
* -price: double                                       *
* -quantity: int                                       *
* -productId: int                                      *
*------------------------------------------------------*        
* +Product(productName: String, productId: int)        *
* +setProductId(productId: int): void                  *
* +getProductId(): int                                 *
* +setPrice(price: double): void                       *
* +getPrice(): int                                     *
* +setQuantity(quantity: int): void                    *
* +getQuantity(): int                                  *
********************************************************/


package Final_Project;

public abstract class Product {
	
	private String productName; //name of product
	private double price; //price of product
	private int quantity; //quantity available of product
	private int productId; //unique ID for product (used for tracking)
	
	//no-arg constructor
	public Product(){
		
	}
	
	//constructor, requires name and ID (default to $0.00 price and 1 quantity?)
	public Product(String productName, int productId){
		
	}
	
	//setter methods
	public void setProductId(int productId){
		
	}
	
	public void setPrice(double price){
		
	}
	
	public void setQuantity(int quantity){
		
	}
	
	//getter methods
	public int getProductId(){
		
	}
	
	public double getPrice(){
		
	}
	
	public int getQuantity(){
		
	}
	
	public String toString(){
		
	}

}
