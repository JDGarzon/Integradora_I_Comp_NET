package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ServerController {
	@FXML
	private TextArea messages;
	
	public void actualize(String text) {
		Platform.runLater(()->{
			messages.appendText("\n"+text);
		});
	}
}
