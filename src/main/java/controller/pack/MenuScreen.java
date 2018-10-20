package controller.pack;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class MenuScreen {

	private MainController mainController;
    @FXML
    void OpenApplication() {
    		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AppScreen.fxml"));
    		Pane pane = null;
    		try {
				pane = loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
    		AppController appController = loader.getController();
    		appController.setMainController(mainController);
    		mainController.setScreen(pane);
   }
    public void setMainController(MainController mainController) {
    	this.mainController = mainController;
    }
}
