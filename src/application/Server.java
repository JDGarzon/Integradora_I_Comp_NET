package application;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

import controller.AddApartmentController;
import controller.ChatController;
import controller.PanicServerViewController;
import controller.ServerHomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Server extends Application {
	/**
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9090);
		Socket socket = server.accept();
		DataInputStream in = new DataInputStream(socket.getInputStream());
		System.out.println(in.readUTF());
	}
	*/
	
	private Stage currentStage;
	private ChatController actualChatController;
	private Hashtable<Integer, String> apartments = new Hashtable<Integer, String>();
	
	public static void main(String[] args) {
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/ServerHomeView.fxml"));
			root = (BorderPane)loader.load();
			ServerHomeController homeController = loader.getController();
			homeController.setServer(this);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			currentStage = stage;
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
	
	public void showPanicScreen(){
		try{
			BorderPane root;
			AnchorPane panicView;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/PanicServerView.fxml"));
			panicView = loader.load();
			PanicServerViewController panicController = loader.getController();
			panicController.setServer(this);
			Stage stage = currentStage;
			root = (BorderPane) stage.getScene().getRoot();
			root.setCenter(panicView);
			stage.show();
			currentStage = stage;
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void showAddView() {
		try{
			BorderPane root;
			AnchorPane addView;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/AddApartmentView.fxml"));
			addView = loader.load();
			AddApartmentController addController = loader.getController();
			addController.setServer(this);
			Stage stage = currentStage;
			root = (BorderPane) stage.getScene().getRoot();
			root.setCenter(addView);
			stage.show();
			currentStage = stage;
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void notifyVisit() {
		
	}
	
	public void addApartment(Integer apartment, String ip) {
		apartments.put(apartment, ip);
	}
	
/**	
	private final static int PORT = 9090;
	
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			ChatMessage chatMessage;
			while(true) {
				Socket socket = serverSocket.accept();
				ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
				chatMessage = (ChatMessage) inStream.readObject();
				System.out.println("\n"+chatMessage.getApartment() +": " + chatMessage.getMessage() );
				
				Socket senderSocket = new Socket(chatMessage.getApartment(),PORT);
				ObjectOutputStream outStream = new ObjectOutputStream(senderSocket.getOutputStream());
				outStream.writeObject(chatMessage);
				
				outStream.close();
				senderSocket.close();
				socket.close();
			}

		}catch(IOException e) {
			System.out.println("Exception caught when trying to listen on port "+ PORT + " or listening for a connection");
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	*/
}
