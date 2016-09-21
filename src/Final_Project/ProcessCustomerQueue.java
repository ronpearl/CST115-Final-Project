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
import java.util.List;
import java.util.Queue;

import com.opencsv.CSVReader;

public class ProcessCustomerQueue extends Product {
	
	protected Queue<String> theQueue = new java.util.LinkedList<>();
	
	public void ProcessCustomerQueue() {
		// Default method
	}
	
	public void readCustomerQueue() throws IOException {
		// Attempt to read customer que from file
		try {
			
			CSVReader custQueue = new CSVReader(new FileReader("purchaseQue.csv"));
			
			// Save entries into a list
			List<String[]> custQueueList = custQueue.readAll();
			
//			System.out.println("-------------- Qued Names --------------");
			
			// Go through the list
			for (int i = 0; i < custQueueList.size(); i++) {
				
				String name = custQueueList.get(i)[0];
				String item = custQueueList.get(i)[1];
				
				theQueue.offer(name + "," + item);
				
//				System.out.println(name + " : " + item);
				
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Run the transactions at a specific interval
		timedTransactions();
		
	}
	
	
	public void timedTransactions() {
		
		while (theQueue.size() > 0) {
			
			System.out.print(theQueue.remove() + "\n");
			
			// Stall the process every 3.5 seconds
			try {
	            Thread.sleep(3500);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
		
	}
	
}