package controller;

import application.Client;
import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SampleController {
	
	Main main;
	
	Client client;
	@FXML
	Button chat;
	
	@FXML
	Button panic;
	
	@FXML
	public void sendPanicAlert() {
		
	}
	
	@FXML
	public void chatScreen() {
		client.showChat();
	}
	
	public void setMain(Main main) {
		this.main =main;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
}
