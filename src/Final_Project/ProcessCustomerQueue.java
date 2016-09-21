/**
 * Class:		ProcessCustomerQueue
 * Date:		9/21/16
 * Use:			This class will utilize a CSV file containing peoples names and a choice
 * 				they will make in the machine. Then it will cue up those purchases
 * 				and display it onto the screen.
 */

package Final_Project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

import com.opencsv.CSVReader;

public class ProcessCustomerQueue extends VendingMachine {
	
	protected Queue<String> theQueue = new java.util.LinkedList<>();
	protected Dispenser disp = new Dispenser();
	
	public ProcessCustomerQueue(Dispenser disp) {
		this.disp = disp;
		
		try {
			readCustomerQueue();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readCustomerQueue() throws IOException {
		// Attempt to read customer que from file
		try {
			
			CSVReader custQueue = new CSVReader(new FileReader("purchaseQue.csv"));
			
			// Save entries into a list
			List<String[]> custQueueList = custQueue.readAll();
			
			System.out.println("\n-------------- Start Customer Queing --------------");
			
			// Go through the list
			for (int i = 0; i < custQueueList.size(); i++) {
				
				String name = custQueueList.get(i)[0];
				String item = custQueueList.get(i)[1];
				
				// Add to the queue
				System.out.println(in(name + "," + item));
				
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Show initial length of queue
		System.out.println(length() + "\n");
		
		// Run the transactions at a specific interval
		timedTransactions();
		
	}
	
	
	public void timedTransactions() {

		while (theQueue.size() > 0) {
			
			// Process transaction for first person in the queue
			startTransaction(theQueue.peek());
			
			// Stall the process every 3.5 seconds
			try {
				System.out.print(out() + "\n");
				System.out.println(length() + "\n");
				
	            Thread.sleep(3500);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
		
		System.out.println(isEmpty());
		
	}
	
	
	/**
	 * doTransaction()
	 * 
	 * Processes the transaction
	 * 
	 * @param toDo
	 */
	public void startTransaction(String toDo) {
		
		String[] toDoArray = toDo.split(",");
		
		String personsName = toDoArray[0];
		String itemToPurchase = toDoArray[1];
		
		boolean itemFound = false;
		boolean itemAvailable = false;
		Product foundItem = null;
		
		// Get products from the dispenser
		ArrayList<Product> mainDispProds = disp.getProducts();
		
		for (int i = 0; i < mainDispProds.size(); i++) {
			
			// Compare product name
			if (mainDispProds.get(i).getName().equals(itemToPurchase)) {
				
				itemFound = true;
				
				// Check availability
				if (mainDispProds.get(i).getQuantity() >= 1) {
					
					itemAvailable = true;
					foundItem = mainDispProds.get(i);
					break;
					
				}
				
			}
			
		}
		
		if (itemFound) {
			if (itemAvailable) {
				
				// Process the transaction
				processTransaction(foundItem);
				
			} else {
				// Get random item from the dispenser
				Product prod = getRandomProduct(mainDispProds);
				
				// Process the purchase
				processTransaction(prod);
				
				System.out.println(personsName + " wanted a " + itemToPurchase + 
						", but there are none available. They purchased a " + prod.getName() + " instead.");
			}
		} else {
			// Get random item from the dispenser
			Product prod = getRandomProduct(mainDispProds);
			
			// Process the purchase
			processTransaction(prod);
			
			System.out.println(personsName + " wanted a " + itemToPurchase + 
					", but was not found in the dispenser. They purchased a " + prod.getName() + " instead.");
		}
		
	}
	
	
	public void processTransaction(Product prod) {
		System.out.println("STILL NEED TO PROCESS TRANSACTION");
	}
	
	
	public Product getRandomProduct(ArrayList<Product> mainDispProds) {
		// Get random item
		int randNum = ThreadLocalRandom.current().nextInt(0, mainDispProds.size() + 1);
		
		return mainDispProds.get(randNum);
	}
	
	
	// Below are the actions for adding and removing from the queue, while
	// also returning statements to reflect these actions.
	public String first() {
		return "First Item in Queue: " + theQueue.peek();
	}
	
	public String length() {
		return "Length of Queue: " + theQueue.size();
	}
	
	public String in(String itemToAdd) {
		theQueue.offer(itemToAdd);
		
		return "Adding to Queue: " + itemToAdd;
	}
	
	public String out() {
		return "Remove from Queue: " + theQueue.remove();
	}
	
	public String isEmpty() {
		return "Queue is empty";
	}

}