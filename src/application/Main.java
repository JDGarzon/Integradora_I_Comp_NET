package application;
	

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	/*
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
	}*/
}
