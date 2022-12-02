package controller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import application.Appartment;
import application.ChatMessage;
import application.Client;
import application.EmailSenderService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ClienController {
	
	String gmail;
	String contact;
	String password;
	
	public void complete(String gmail,String contact,String password) {
		this.gmail=gmail;
		this.contact=contact;
		this.password=password;
	}
	
	@FXML
	TextField send;
	@FXML
	TextArea received;
	@FXML
	TextField ip;
	@FXML
	TextField nick;
	
	private final String PORT="192.168.56.1";
	
	Appartment myApp;
	
	Client client;
	
	public void setClient(Client client) {
		this.client=client;
	}
	
	public void setApp(Appartment app) {
		myApp=app;
	}
	
	@FXML
	public void sendMesage() {
		ChatMessage msg=new ChatMessage(nick.getText(),send.getText(),ip.getText());
		try {
			@SuppressWarnings("resource")
			Socket sock=new Socket(PORT,9999);
			ObjectOutputStream stream=new ObjectOutputStream(sock.getOutputStream());
			stream.writeObject(msg);
			stream.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public void actualize(String text) {
		Platform.runLater(()->{
			received.appendText("\n"+text);
		});
	}
	
	
	@FXML
	public void redButton() {
		EmailSenderService send=new EmailSenderService();
		send.sendMail(gmail, password, contact, "Hay una emergencia en mi apartamento", "�EMERGENCIA!");
		ChatMessage msg=new ChatMessage(myApp.getNum()+"","Es una emergencia",PORT);
		try {
			@SuppressWarnings("resource")
			Socket sock=new Socket(PORT,9999);
			ObjectOutputStream stream=new ObjectOutputStream(sock.getOutputStream());
			stream.writeObject(msg);
			stream.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
