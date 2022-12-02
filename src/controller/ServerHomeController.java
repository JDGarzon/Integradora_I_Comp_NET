package controller;

import application.Server;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ServerHomeController {
	
	Server server;
	
	@FXML
	TextField apartment;
	
	@FXML
	Button addApartment;
	
	@FXML
	TextField visitantName;
	
	@FXML
	Button notifyVisit;
	
	@FXML
	public void add() {
		server.showAddView();
	}
	
	@FXML
	public void adviceVisit() {
		server.notifyVisit();
	}
	
	public void setServer(Server server) {
		this.server = server;
	}
}
