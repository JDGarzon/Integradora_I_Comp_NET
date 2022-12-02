package controller;

import application.Server;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 * Es la clase encargada de controlar la interfaz ServerHome
 */
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
	/**
	 * Es la clase encargada de cambiar a la visra de AddApartmentView
	 */
	@FXML
	public void add() {
		Platform.runLater(()->{
			server.showAddView();
		});
		
	}
	/**
	 * Es el metodo encargado notificar sobre un visitante a un apartamento
	 */
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
