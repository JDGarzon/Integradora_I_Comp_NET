package controller;

import application.Server;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PanicViewController {
	
	Server server;

	@FXML
	Label apartment;
	
	@FXML
	Button back;
	
	public void backView() {
		server.showHome();
	}
	
	public void setServer(Server server) {
		this.server = server;
	}
	
	public void setApp(String app) {
		apartment.setText("Appartment:"+app);
	}
	
}
