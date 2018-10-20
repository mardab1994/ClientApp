package controller.pack;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AppController {
	
	/*private final int CIPHER_MODE_NONE 	= 0;
	private final int CIPHER_MODE_XOR   = 1;
	private final int CIPHER_MODE_CESAR = 2;
	*/
	
	private String nick="NoName";
	private int cipherMode=0;
	
	private MainController mainController;
	
    @FXML
    private TextField chatFiled;

    @FXML
    private TextField messageBox;

	
	@FXML
    void sendMessage() {
	    	System.out.println("Wysy³anie wiadomoœci");
	    	System.out.println(this.nick);
    }
	public void setMainController(MainController mainController) {
		this.mainController=mainController;
	}
	
	public void setParam(final String Nick, final int CipherMode) {
		if(Nick!="") {
			this.nick = Nick;
		}
		this.cipherMode = CipherMode;
	}
}

