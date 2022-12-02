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
import controller.SingInController;
import javafx.application.Application;


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
	
	public void showVisitAdvice(){
		
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
				
				switch (msg.getType()){
				case ALLOW:
					
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

	public void actualize() {
		// TODO Auto-generated method stub
		
	}

	public void sendMessage(ChatMessage chatMessage) {
		// TODO Auto-generated method stub
		
	}
	
	
}
