package controller;

import application.Client;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SingInController {
	
	Client client;

	@FXML
	TextField gmail;

	@FXML
	TextField contactGmail;
	
	@FXML
	TextField password;
	
	@FXML
	public void enter() {
		client.showChat();
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
}
