package application;

public class Appartment {
	private String gmail;
	private String contact;
	private String password;
	private String ip;
	private int number;
	
	public Appartment(int number,String gmail,String contact,String password,String ip) {
		this.setGmail(gmail);
		this.setContact(contact);
		this.setPassword(password);
		this.setIp(ip);
		this.number=number;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getNum() {
		return number;
	}
}
