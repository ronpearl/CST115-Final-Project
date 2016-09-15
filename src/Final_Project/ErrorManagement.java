package Final_Project;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ErrorManagement {
	ErrorManagement() {
		
	}
	
	public static void sendAlert(AlertType alertType, String title, String header, String content) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(header);
	    alert.setContentText(content);
	    alert.showAndWait();
	}
}