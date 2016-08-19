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
	public Product(String productName, double price, int quantity, int productId){
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.productId = productId;
	}
	
	//setter methods
	public void setProductName(String name) {
		this.productName = name;
	}
	
	public void setProductId(int productId){
		
	}
	
	public void setPrice(double price){
		
	}
	
	public void setQuantity(int quantity){
		
	}
	
	//getter methods
	public String getName() {
		return productName;
	}
	
	public int getProductId(){
		return productId;
	}
	
	public double getPrice(){
		return price;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	@Override
	public String toString(){
		return "Product Name: " + productName + ", Price: " + price + ", Quantity: " + quantity + ", Product ID: " + productId;
	}

}
