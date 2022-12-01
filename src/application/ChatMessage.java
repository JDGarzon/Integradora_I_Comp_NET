package application;

import java.io.Serializable;

public class ChatMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ip;
	private String apartment;
	private String message;
	
	public ChatMessage(String apartment, String message) {
		this.apartment = apartment;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getApartment() {
		return apartment;
	}

	public String getIp() {
		return ip;
	}
	
	
}
