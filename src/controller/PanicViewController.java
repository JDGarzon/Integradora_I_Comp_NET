package controller;

import application.Server;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
/**
 * Es la clase encargada de controlar la interfaz PanicView
 * @author kizyz
 *
 */
public class PanicViewController {
	
	Server server;

	@FXML
	Label apartment;
	
	@FXML
	Button back;
	/**
	 * Es el metodo encargado de retroceder a la pagina anterior
	 */
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
