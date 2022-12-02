package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
/**
 * Es la clase encarga de controlar la interfaz Server
 * @author kizyz
 *
 */
public class ServerController {
	@FXML
	private TextArea messages;
	
	public void actualize(String text) {
		Platform.runLater(()->{
			messages.appendText("\n"+text);
		});
	}
}
