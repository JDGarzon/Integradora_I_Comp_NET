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
	TextField num;
	
	@FXML
	public void enter() {
		client.complete(gmail.getText(), contactGmail.getText(), password.getText(),num.getText());
		client.showChat();
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
}
