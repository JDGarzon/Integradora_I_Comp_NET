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
/**
 * Es la clase encargada de controlar la interfaz ClientController
 * @author kizyz
 *
 */
public class ClienController {
	
	String gmail;
	String contact;
	String password;
	String num;
	/**
	 * Metodo encargado de completar los campos
	 * @param gmail es el gmail del dueño del apartamento
	 * @param contact Es el gmail del contacto de emergencia del dueño del apartamento
	 * @param password Es la contraseña de aplicación del gmail del dueño de apartamento
	 * @param num Es el numero de apartamento
	 */
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
	
	private final String PORT="192.168.56.1";
	
	
	
	Client client;
	
	public void setClient(Client client) {
		this.client=client;
	}
	
	/**
	 * Es el metodo encargado de enviar un mensaje
	 */
	@FXML
	public void sendMesage() {
		ChatMessage msg=new ChatMessage(ip.getText(),send.getText(),ip.getText(),Type.NORMAL);
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
	/**
	 * Es el metodo encargado de actualizar el chat
	 * @param text Es el texto que se agregara al chat
	 */
	public void actualize(String text) {
		Platform.runLater(()->{
			received.appendText("\n"+text);
		});
	}
	/**
	 * Es el metodo que permite el ingreso de la persona al apartamento
	 */
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
	/**
	 * Es el metodo que niega el ingreso de la persona al apartamento
	 */
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
	
	/**
	 * Es el metodo encargado del boton de emergencia
	 */
	@FXML
	public void redButton() {
		EmailSenderService send=new EmailSenderService();
		
		ChatMessage msg=new ChatMessage(num,"Es una emergencia",PORT,Type.EMERGENCE);
		try {
			@SuppressWarnings("resource")
			Socket sock=new Socket(PORT,9999);
			ObjectOutputStream stream=new ObjectOutputStream(sock.getOutputStream());
			stream.writeObject(msg);
			send.sendMail(gmail, password, contact, "Hay una emergencia en mi apartamento", "ï¿½EMERGENCIA!");
			stream.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
