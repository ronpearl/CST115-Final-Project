/*******************************************************
*                      Product	                       *
*------------------------------------------------------*
* -productName: String                                 *
* -price: double                                       *
* -quantity: int                                       *
* -dispenseLocation: String                            *
* -productId: int                                      *
*------------------------------------------------------*   
* +Product()								           *     
* +Product(productName: String, price:double,          *
* quantity:int, dispenseLocation: String,              *
* productId: int)                                      *
* +setProductName(name: String):void                   *
* +setProductId(productId: int): void                  *
* +setPrice(price: double): void                       *
* +setQuantity(quantity: int): void                    *
* +setDispenseLocation(location: String): void         *
* +getProductName(): String                            *
* +getProductId(): int                                 *
* +getPrice(): int                                     *
* +getQuantity(): int                                  *
* +getDispenseLocation(): String                       *
* +toString(): toString 							   *
********************************************************/


package Final_Project;

public abstract class Product extends ErrorManagement {
	
	private String productName; 		// name of product
	private double price; 				// price of product
	private int quantity; 				// quantity available of product
	private int temporaryQuantity; 		// quantity available of product during transaction
	private String prodDescription;		// Product description
	private String dispenseLocation; 	// Location in the dispenser
	private int productId; 				// unique ID for product (used for tracking)
	
	//no-arg constructor
	public Product(){
		
	}
	
	//constructor, requires name and ID (default to $0.00 price and 1 quantity?)
	public Product(String productName, double price, int quantity, String dispenseLocation, int productId, String prodDescription){
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.temporaryQuantity = quantity;
		this.prodDescription = prodDescription;
		this.dispenseLocation = dispenseLocation;
		this.productId = productId;
	}
	
	//setter methods
	public void setProductName(String name) {
		this.productName = name;
	}
	
	public void setProductId(int productId){
		this.productId = productId;
	}
	
	public void setProductDescription(String desc) {
		this.prodDescription = desc;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
		
		// Also reset temporary quantity
		this.temporaryQuantity = quantity;
	}
	
	public void setTemporaryQuantity(int tempQuantity){
		this.temporaryQuantity = tempQuantity;
	}
	
	public void setDispenseLocation(String location){
		this.dispenseLocation = location;
	}
	
	//getter methods
	public String getName() {
		return productName;
	}
	
	public int getProductId(){
		return productId;
	}
	
	public String getDescription() {
		return prodDescription;
	}
	
	public double getPrice(){
		return price;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public int getTemporaryQuantity(){
		return temporaryQuantity;
	}
	
	public String getDispenseLocation(){
		return dispenseLocation;
	}

	
	public int compareName(Product prod) {
		if (this.getName().charAt(0) > prod.getName().charAt(0)) {
			return 1;
		} else if (this.getName().charAt(0) == prod.getName().charAt(0) ) {
			if (this.getName().charAt(1) > prod.getName().charAt(1)) {
				return 1;
			} else if (this.getName().charAt(1) == prod.getName().charAt(1) ) {
				if (this.getName().charAt(2) > prod.getName().charAt(2)) {
					return 1;
				} else {
					return 0;
				}
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}
	
	
	public int compareQty(Product prod) {
		if (this.getQuantity() > prod.getQuantity()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
	@Override
	public String toString(){
		return "Product Name: " + productName + ", Price: " + price + ", Quantity: " + quantity + 
				", Dispenser Location: " + dispenseLocation + ", Product ID: " + productId;
	}

}