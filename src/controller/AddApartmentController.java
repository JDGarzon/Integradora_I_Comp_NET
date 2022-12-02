package controller;

import application.Server;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
/**
 * El la clase encargada de controlar la interfaz AddApartment
 *
 */
public class AddApartmentController {
	
	Server server;


	
	@FXML
	TextField apartmentNumber;
	
	@FXML
	TextField ip;
	
	/**
	 * Es el metodo encargado de añadir un apartamento
	 */
	@FXML
	public void addApartment() {
		server.addApartment(Integer.parseInt(apartmentNumber.getText()),ip.getText());
	}
	/**
	 * Es el metodo encargado de retroceder a la pantalla anterior
	 */
	@FXML
	public void backView() {
		server.showHome();
	}
	
	public void setServer(Server server) {
		this.server = server;
	}
}
