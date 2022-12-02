package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import controller.ClienController;
import javafx.application.Application;


public class Client extends Application implements Runnable {
	
	ClienController controller;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Client.fxml"));
			BorderPane root = (BorderPane)loader.load();
			controller = loader.getController();
			Scene scene = new Scene(root,300,300);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			controller.setClient(this);
			Thread thread=new Thread(this);
			thread.start();;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void run() {
		
		try {
			@SuppressWarnings("resource")
			ServerSocket servClient=new ServerSocket(9090);
			Socket client;
			ChatMessage msg;
			while(true) {
				client=servClient.accept();
				ObjectInputStream stream=new ObjectInputStream(client.getInputStream());
				msg=(ChatMessage)stream.readObject();
				String text=msg.getApartment()+": "+msg.getMessage();
				controller.actualize(text);
					
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void actualize() {
		// TODO Auto-generated method stub
		
	}

	public void sendMessage(ChatMessage chatMessage) {
		// TODO Auto-generated method stub
		
	}

	public void showChat() {
		// TODO Auto-generated method stub
		
	}
	
	
}
