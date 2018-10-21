package controller.pack;

import java.net.URL;
import java.util.ResourceBundle;

import connection.pack.Session;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AppController {
	
	/*private final int CIPHER_MODE_NONE 	= 0;
	private final int CIPHER_MODE_XOR   = 1;
	private final int CIPHER_MODE_CESAR = 2;
	*/
	
	private String nick="NoName";
	private int cipherMode=0;
	private Session mySession = new Session();
	private MainController mainController;
	private String lines="";
		
    @FXML
    private TextArea chatField;

    @FXML
    private TextField messageBox;

    Task task = new Task<Void>() {
	    @Override public Void call() {
	       while(!isCancelled()) {
	        	String receivedMsg = mySession.communication();
	        	if(receivedMsg!="") {
	        		lines=lines+receivedMsg+"\n";
	        		chatField.setText(lines);
	        	}
	       }
	        return null;
	    }
	};
	
	@FXML	//works fine
    void sendMessage() {
		String msg=messageBox.getText();
		mySession.sendMessage(this.nick+": "+msg);
		messageBox.clear();
		lines = lines +"You: "+msg+"\n";
		chatField.setText(lines);
    }

	public void setMainController(MainController mainController) {
		this.mainController=mainController;
	}
	
	public void setParam(final String Nick, final int CipherMode) {
		if(Nick!="") {
			this.nick = Nick;
		}
		this.cipherMode = CipherMode;
		mySession.init();
		new Thread(task).start();
	}
	
	
}

