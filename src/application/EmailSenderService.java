package application;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * Es la clase que representa el servicio de mail
 *
 */
public class EmailSenderService {
	/**
	 * Es el metodo encargado de enviar email
	 * @param sender Es el correo del usuario que envia el mensaje
	 * @param password Es la contraseña de aplicacion con del correso del usuario
	 * @param to Es el correo de la persona a la cual esta dirigido el mensaje
	 * @param subject Es el asunto del correo
	 * @param body Es el cuerpo del correo
	 */
	public void sendMail(String sender,String password,String to, String subject, String body) {

	     // Para la dirección nomcuenta@gmail.com

	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com"); // El servidor SMTP de Google
	    props.put("mail.smtp.user", sender);
	    props.put("mail.smtp.clave", password); // Pass cuenta
	    props.put("mail.smtp.auth", "true"); // Autenticación mediante usuario y pass
	    props.put("mail.smtp.starttls.enable", "true"); // Conexió segura al servidor
	    props.put("mail.smtp.port", "587"); // Puerto SMTP seguro de Google

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(sender));
	        message.addRecipients(Message.RecipientType.TO, to);
	        message.setSubject(subject);
	        message.setText(body);
	        Transport transport = session.getTransport("smtp");
	        System.out.println("sda");
	        System.out.println(sender+":"+password);
	        transport.connect("smtp.gmail.com", sender, password);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    } catch (MessagingException me) {
	        me.printStackTrace();
	    }
	}

}