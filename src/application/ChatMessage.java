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
	private Type type;
	
	public ChatMessage(String apartment, String message,String ip,Type type) {
		this.apartment = apartment;
		this.message = message;
		this.ip=ip;
		this.type=type;
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

	public Type getType() {
		return type;
	}
	
	
}
