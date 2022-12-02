package controller;

import application.ChatMessage;
import application.Client;
import application.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
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
	@FXML
	public void back() {
		client.showHome();
	}
	
	@FXML
	public void send() {
		String messageToSend = message.getText();
		if (messageToSend.length() != 0) {
			chat.appendText("\n" + "Me: "+messageToSend);
			String ip = ipSelector.getText();
			//String apartment = myApartment.getText();
			client.sendMessage(new ChatMessage(ip,messageToSend));
			
		}
	}
	
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