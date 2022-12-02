package controller;

import application.Server;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddApartmentController {
	
	Server server;


	
	@FXML
	TextField apartmentNumber;
	
	@FXML
	TextField ip;
	
	
	@FXML
	public void addApartment() {
		server.addApartment(Integer.parseInt(apartmentNumber.getText()),ip.getText());
	}
	
	@FXML
	public void backView() {
		server.showHome();
	}
	
	public void setServer(Server server) {
		this.server = server;
	}
}
