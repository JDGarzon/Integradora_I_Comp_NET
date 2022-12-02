package application;
	
import java.io.IOException;

import controller.ChatController;
import controller.SampleController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private Stage currentStage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			showHome();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showHome() {
		try {
			BorderPane root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
			root = loader.load();
			SampleController homeController = loader.getController();
			homeController.setMain(this);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			currentStage = stage;
		}catch(IOException e) {
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
			chatController.setMain(this);
			Stage stage = currentStage;
			root = (BorderPane) stage.getScene().getRoot();
			root.setCenter(chat);
			stage.show();
			currentStage = stage;
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
