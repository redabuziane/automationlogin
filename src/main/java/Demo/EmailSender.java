package Demo;

import java.io.File;
import java.util.Properties;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailSender {
	public static void main(String[] args) {
		
		final String senderEmail = "redathd999@gmail.com";
		final String appPassword = "jiizbiullobzhfug";
		final String recepientEmail = "redathd9999@gmail.com";

		// SMTP Server Properties
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.auth", "true");
		
		// Create session with Authentication
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, appPassword);

			}
		});
		session.setDebug(true);
		
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recepientEmail));
			message.setSubject("Test Email from qa automation");
			
		//	message.setText("Hello \n this is a test email from java \n regards , \n nqa Team ");
			// Send Email
			
			// Email Body Part 
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText("Hello \n\n This is a test email from java \n regards , \n nQa Team ");
			// Attachment Part 
			MimeBodyPart attachmentPart = new MimeBodyPart();
			String filePath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
			System.out.println("Attachment path is - " + filePath );
			attachmentPart.attachFile(new File(filePath) );
			// Combine body and attachment parts 
			MimeMultipart multipart = new MimeMultipart ();
			multipart.addBodyPart(textPart);
			multipart.addBodyPart(attachmentPart);
			message.setContent(multipart);
			
			
			Transport.send(message);
			System.out.println("Email sent successfully ***");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
