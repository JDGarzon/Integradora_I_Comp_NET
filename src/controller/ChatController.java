package controller;

import application.Client;
import application.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatController {
	
	Main main;
	
	Client client;

	@FXML
	Button backButton;
	
	@FXML
	Button sendButton;
	
	@FXML
	TextField message;
	
	@FXML
	TextArea chat;
	
	@FXML
	TextField ipSelector;
	/**
	@FXML
	MenuButton serverSelectionMenu;
	
	@FXML
	MenuItem myApartment;
	*/
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public void actualize() {
		Platform.runLater(() -> {
			while (true) {
				try {
					Thread.sleep(1000/20);
					client.actualize();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
