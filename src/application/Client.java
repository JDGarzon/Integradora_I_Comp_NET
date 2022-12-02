package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import controller.AllowController;
import controller.ClienController;
import controller.SingInController;
import javafx.application.Application;
import javafx.application.Platform;

/**
 * Es el cliente con el cual los usuarios interactuan para comunicarse
 *
 */

public class Client extends Application implements Runnable {
	
	ClienController controller;
	
	Stage currentStage;
	
	String gmail;
	String contact;
	String password;
	String num;
	public void complete(String gmail,String contact,String password,String num) {
		this.gmail=gmail;
		this.contact=contact;
		this.password=password;
		this.num=num;
	}
	
	
	/**
	 * Es el metodo encargado de iniciar el programa
	 * @param primaryStage El parametro primaryStage es la stage inicial
	 */
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/EnterSingIn.fxml"));
			BorderPane root = (BorderPane)loader.load();
			SingInController controller = loader.getController();
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			currentStage = primaryStage;
			controller.setClient(this);
			
			Thread thread=new Thread(this);
			thread.start();;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Es el metodo encargado de mostrar el chat
	 */
	public void showChat() {
		try{
			BorderPane root;
			BorderPane chatView;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Client.fxml"));
			chatView = loader.load();
			controller = loader.getController();
			controller.setClient(this);
			controller.complete(gmail, contact, password,num);
			Stage stage = currentStage;
			root = (BorderPane) stage.getScene().getRoot();
			root.setCenter(chatView);
			stage.show();
			currentStage = stage;
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	/**
	 * Es el metodo encargado de mostrar las opciones de si permitir ingresar a alguien o no
	 * @param name El parametro name es el nombre de la persona que quiere ingresar
	 */
	public void showAllow(String name) {
		try{
			BorderPane root;
			BorderPane allowView;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/AllowPermision.fxml"));
			allowView = loader.load();
			AllowController allowController = loader.getController();
			allowController.setClient(this);
			allowController.setName(name);
			Stage stage = currentStage;
			root = (BorderPane) stage.getScene().getRoot();
			root.setCenter(allowView);
			
			stage.show();
			currentStage = stage;
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Metodo encargado de mantener el cliente escuchando por posibles respuestas
	 */
	@Override
	public void run() {
		
		try {
			@SuppressWarnings("resource")
			ServerSocket servClient=new ServerSocket(9090);
			Socket client;
			
			while(true) {
				client=servClient.accept();
				ObjectInputStream stream=new ObjectInputStream(client.getInputStream());
				final ChatMessage msg=(ChatMessage)stream.readObject();
				
				switch (msg.getType()){
				case ALLOW:
					
					Platform.runLater(()->{
						showAllow(msg.getApartment());
					});
					
					break;
				case EMERGENCE:
					break;
				case NORMAL:
					String text=msg.getApartment()+": "+msg.getMessage();
					controller.actualize(text);
					break;
				default:
					break;
					
				}
				
					
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * Niega el acceso de una persona
	 */
	public void deny() {
		controller.deny();
	}
	/**
	 * Permite el acceso de una persona
	 */
	public void allow() {
		controller.allow();
	}
	
	
}
