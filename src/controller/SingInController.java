package controller;

import application.Client;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * 
 * El controlador de la intefaz donde se ingresa la informacion de un host cliente del apartamento
 */
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
	/**
	 * Indica que ya se han ingresado a los datos y llama al metodo que carga la pantalla de chat
	 */
	@FXML
	public void enter() {
		client.complete(gmail.getText(), contactGmail.getText(), password.getText(),num.getText());
		client.showChat();
	}
	/**
	 * Reemplaza el cliente con el que se indica por parametro
	 * @param client el cliente con el que se reemplaza al actual
	 */
	public void setClient(Client client) {
		this.client = client;
	}
}
