package controller.pack;

import javafx.fxml.FXML;

public class AppController {
	
	private MainController mainController;
	
	    @FXML
    void sendMessage() {
	    	System.out.println("Wysy�anie wiadomo�ci");
    }
	public void setMainController(MainController mainController) {
		this.mainController=mainController;
	}
}
