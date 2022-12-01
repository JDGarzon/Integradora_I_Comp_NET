package application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private final static int PORT = 9090;
	
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			Socket socket = serverSocket.accept();
			ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
			ChatMessage chatMessage = (ChatMessage) inStream.readObject();
			System.out.println("\n"+chatMessage.getApartment() +": " + chatMessage.getMessage() );
			
			Socket senderSocket = new Socket("192.168.100.19",9090);
			ObjectOutputStream outStream = new ObjectOutputStream(senderSocket.getOutputStream());
			outStream.writeObject(chatMessage);
		}catch(IOException e) {
			System.out.println("Exception caught when trying to listen on port "+ PORT + " or listening for a connection");
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
