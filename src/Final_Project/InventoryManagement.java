package Final_Project;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert.AlertType;

public class InventoryManagement extends Product {
	
	protected ObservableList<String> basketObservableList;
	protected ArrayList<String> basketListItems = new ArrayList<String>();
	
	InventoryManagement() {
		
	}
	
	/**
	 * sellItem()
	 * 
	 * Reduce the number of items for a specific product based on a sale
	 * 
	 * @param prod
	 * @param qty
	 */
	public boolean addToBasket(Product prod, int qty) {
		String errorMsg = "";
		
		// Make sure enough products are available
		if (prod.getTemporaryQuantity() <= 0) {
			if (prod.getTemporaryQuantity() == 0)
				errorMsg = "Sorry, there are no " + prod.getName() + " left. Please try another item.";
			else
				errorMsg = "Sorry, only " + prod.getQuantity() + " left of " + prod.getName() + ". Please try another item.";
				
			sendAlert(AlertType.ERROR, "Item Unavailable", "Item Unavailable", errorMsg);
			
			return false;
		} else {
			prod.setTemporaryQuantity(prod.getTemporaryQuantity() - qty);
			
			// Add to the basket
			basketListItems.add( prod.getName() + " - " + prod.getProductId() + " - $" + prod.getPrice() );
			updateBasketObsList();
			
			return true;
		}
	}
	
	
	public void removeFromBasket(Dispenser mainDisp, int prodId, int itemInList) {
		// Remove from Observable List
		basketObservableList.remove(itemInList);
		
		// Remove from ArrayList
		for (int j = 0; j < basketListItems.size(); j++) {
			String[] itemToRemove = basketListItems.get(j).split(" - ");
			
			if (Integer.parseInt(itemToRemove[1]) == prodId) {
				basketListItems.remove(j);
			}
		}
		
		// Remove from product temporary count
		for (int i = 0; i < mainDisp.getProducts().size(); i++) {
			Product theProd = mainDisp.getProducts().get(i);
			
			// If selected prodId matches, update the quantities
			if (theProd.getProductId() == prodId) {
				theProd.setTemporaryQuantity( theProd.getTemporaryQuantity() + 1 );
			}
		}
	}
	
	
	public double getBasketTotal() {
		double tempTotal = 0.00;
		
		for (int k = 0; k < basketListItems.size(); k++) {
			String[] itemToRemove = basketListItems.get(k).split(" - ");
			
			tempTotal += Float.parseFloat(itemToRemove[2].replace("$", ""));
		}
		
		return Math.round(tempTotal * 100D) / 100D;
	}
	
	
	private void updateBasketObsList() {		
		String[] tempListItems = new String[basketListItems.size()];
		
		for (int i = 0; i < basketListItems.size(); i++) {
			tempListItems[i] = basketListItems.get(i);
		}
		
		basketObservableList = FXCollections.observableArrayList(tempListItems);
	}
	
	
	// Getters
	public ObservableList<String> getBasketObsList() {
		return basketObservableList;
	}
}