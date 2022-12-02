package application;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import controller.AddApartmentController;
import controller.PanicViewController;
import controller.ServerController;
import controller.ServerHomeController;

public class Server extends Application implements Runnable{
	
	ServerController controller;
	AddApartmentController conntrollApart;
	Hashtable<Integer,Appartment> apartments;
	Stage currentStage;
	/*
	@Override
	public void start(Stage primaryStage) {
		try {
			apartments=new Hashtable<>();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Server.fxml"));
			File file=new File("");
			System.out.println(file.getAbsolutePath());
			BorderPane root = (BorderPane)loader.load();
			controller=loader.getController();
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			currentStage = primaryStage;
			
			Thread thread=new Thread(this);
			thread.start();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	  public void start(Stage primaryStage) {
		try {
			BorderPane root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/ServerHomeView.fxml"));
			
			File file=new File("");
			System.out.println(file.getAbsolutePath());
			
			root = (BorderPane)loader.load();
			ServerHomeController homeController = loader.getController();
			homeController.setServer(this);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			currentStage = stage;
			Thread thread=new Thread(this);
			thread.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showHome() {
		try{
			BorderPane root;
			BorderPane homeView;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/ServerHomeView.fxml"));
			homeView = loader.load();
			ServerHomeController homeController = loader.getController();
			homeController.setServer(this);
			Stage stage = currentStage;
			root = (BorderPane) stage.getScene().getRoot();
			root.setCenter(homeView);
			stage.show();
			currentStage = stage;
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public void showPanicScreen(String num){
		try{
			BorderPane root;
			AnchorPane panicView;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/PanicView.fxml"));
			panicView = loader.load();
			
			PanicViewController panicController = loader.getController();
			panicController.setServer(this);
			Stage stage=currentStage;
			root = (BorderPane) stage.getScene().getRoot();
			panicController.setApp(num);
			root.setCenter(panicView);
			
			stage.show();
			
			currentStage = stage;
		}catch(IOException e){
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
			ServerSocket server=new ServerSocket(9999);
			while(true) {
				Socket msck=server.accept();
				ObjectInputStream stream=new ObjectInputStream(msck.getInputStream());
				ChatMessage msg=(ChatMessage)stream.readObject();
				
				switch(msg.getType()) {
				case NORMAL:
					String text=msg.getApartment()+"\n"+msg.getIp()+"\n"+msg.getMessage();
					controller.actualize(text);
					Socket sender=new Socket(msg.getIp(),9090);
					ObjectOutputStream toSend=new ObjectOutputStream(sender.getOutputStream());
					toSend.writeObject(msg);
					sender.close();
					msck.close();
					stream.close();
					break;
				case EMERGENCE:
					Platform.runLater(()->{
						
						showPanicScreen(msg.getApartment());
					});
					
					break;
				case ALLOW:
					msck.close();
					stream.close();
					break;
				default:
					msck.close();
					stream.close();
					break;
				}
				msck.close();
				stream.close();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void addApartment(int aprtmentNum, String gmail,String contact,String password, String ip) {
		Appartment app=new Appartment(aprtmentNum,gmail,contact,password,ip);
		apartments.put(aprtmentNum, app);
		
	}

	public void showAddView() {
		
		try {
			Stage stage=new Stage();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/AddpartmentView.fxml"));
	
			BorderPane root;
			root = (BorderPane)loader.load();
			conntrollApart=loader.getController();
			
			conntrollApart.setServer(this);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void notifyVisit() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
