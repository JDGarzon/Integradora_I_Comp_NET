package controller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import application.ChatMessage;
import application.Client;
import application.EmailSenderService;
import application.Type;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ClienController {
	
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
	
	@FXML
	TextField send;
	@FXML
	TextArea received;
	@FXML
	TextField ip;
	@FXML
	TextField nick;
	
	private final String PORT="192.168.56.1";
	
	
	
	Client client;
	
	public void setClient(Client client) {
		this.client=client;
	}
	
	
	@FXML
	public void sendMesage() {
		ChatMessage msg=new ChatMessage(nick.getText(),send.getText(),ip.getText(),Type.NORMAL);
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
	
	public void allow() {
		ChatMessage msg=new ChatMessage(num,"YES",PORT,Type.ALLOW);
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
	
	public void deny() {
		ChatMessage msg=new ChatMessage(num,"NO",PORT,Type.ALLOW);
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
	
	
	@FXML
	public void redButton() {
		EmailSenderService send=new EmailSenderService();
		
		ChatMessage msg=new ChatMessage(num,"Es una emergencia",PORT,Type.EMERGENCE);
		try {
			@SuppressWarnings("resource")
			Socket sock=new Socket(PORT,9999);
			ObjectOutputStream stream=new ObjectOutputStream(sock.getOutputStream());
			stream.writeObject(msg);
			send.sendMail(gmail, password, contact, "Hay una emergencia en mi apartamento", "�EMERGENCIA!");
			stream.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
