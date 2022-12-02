package controller;

import application.Server;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	Label answer;
	
	@FXML
	public void add() {
		Platform.runLater(()->{
			server.showAddView();
		});
		
	}
	
	@FXML
	public void adviceVisit() {
		server.notifyVisit(visitantName.getText(),apartment.getText());
	}
	
	public void setServer(Server server) {
		this.server = server;
	}
	
	public void setAnswer(String ans) {
		answer.setText("Answer:"+ans);
	}
}
