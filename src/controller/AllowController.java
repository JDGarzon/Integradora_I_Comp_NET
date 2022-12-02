package controller;

import application.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AllowController {
	
	Client client;

	@FXML
	Label name;
	
	@FXML
	public void allowAcces() {
		client.showChat();
	}
	
	@FXML
	public void denyAcces() {
		client.showChat();
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public void setName(String name) {
		this.name.setText(name);
	}
}
