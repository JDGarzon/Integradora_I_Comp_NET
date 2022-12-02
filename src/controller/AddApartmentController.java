package controller;

import application.Server;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class AddApartmentController {
	
	Server server;

	@FXML
	Button back;
	
	@FXML
	TextArea apartmentNumber;
	
	@FXML
	TextArea ip;
	
	@FXML
	TextArea gmailUser;
	
	@FXML
	TextArea gmailContact;
	
	@FXML
	TextArea password;
	
	@FXML
	Button add;
	
	public void addApartment() {
		server.addApartment(Integer.parseInt(apartmentNumber.getText()), gmailUser.getText(),gmailContact.getText(),password.getText(),ip.getText());
	}
	
	public void backView() {
		server.showHome();
	}
	
	public void setServer(Server server) {
		this.server = server;
	}
}
