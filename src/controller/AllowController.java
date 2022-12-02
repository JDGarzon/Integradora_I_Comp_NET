package controller;

import application.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
/**
 * Es la clase encargada de controlar la interfaz Allow
 * @author kizyz
 *
 */
public class AllowController {
	
	Client client;

	@FXML
	Label name;
	/**
	 * Es el metodo que da permiso a la persona a ingresar al apartamento
	 */
	@FXML
	public void allowAcces() {
		client.allow();
		client.showChat();
	}
	/**
	 * Es el metodo que niega a la persona a ingresar al apartamento
	 */
	@FXML
	public void denyAcces() {
		client.deny();
		client.showChat();
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public void setName(String name) {
		this.name.setText(name);
	}
}
