package application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Client extends Application {
	
		private final static int PORT = 9090;
		
		private Stage currentStage;
		
		public static void main(String[] args) {
			launch(args);
		}
		
		@Override
		public void start(Stage primaryStage) {
			try {
				showHome();
				ServerSocket serverSocket = new ServerSocket(PORT);
				while(true) {
					Socket socket = serverSocket.accept();
					ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
					ChatMessage message = (ChatMessage) inStream.readObject();
					System.out.println(message.getMessage());
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public void showHome() {
			
			try {
				BorderPane root;
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
				root = (BorderPane)loader.load();
				SampleController homeController = loader.getController();
				homeController.setClient(this);
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();
				currentStage = stage;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public void showChat(){
			try{
				BorderPane root;
				AnchorPane chat;
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Chat.fxml"));
				chat = loader.load();
				ChatController chatController = loader.getController();
				chatController.setClient(this);
				Stage stage = currentStage;
				root = (BorderPane) stage.getScene().getRoot();
				root.setCenter(chat);
				stage.show();
				currentStage = stage;
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		public void sendMessage(ChatMessage message) {
			try {
				Socket socket = new Socket(message.getIp(),9090);
				ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
				outStream.writeObject(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

