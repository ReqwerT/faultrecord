package login;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

class GMailAuthenticator extends Authenticator {
    String user;
    String pw;
    public GMailAuthenticator (String username, String password)
    {
       super();
       this.user = username;
       this.pw = password;
    }
   public PasswordAuthentication getPasswordAuthentication()
   {
      return new PasswordAuthentication(user, pw);
   }
}


public class MailSend {

	
	public static void mailsend(String subject,String message1,List<String> mail) {

		try {
			String from ="arizakayit16@hotmail.com";	
			String pass = "123456789sss";
			GMailAuthenticator asd = new GMailAuthenticator(from,pass);
			String [] to =  {mail.get(0)};
			String host  = "smtp.outlook.com";
			
			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable","true");
			props.put("mail.smtp.host",host);
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.password", pass);
			props.put("mail.smtp.port", "25");
			props.put("mail.smtp.auth", "true");
			
			
			Session session = Session.getInstance(props, new GMailAuthenticator(from, pass));
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			InternetAddress [] toAddress = new InternetAddress[to.length];
			for(int i=0;i<toAddress.length;i++) {
				toAddress[i] = new InternetAddress(to[i]);
				
			}
			for(int i=0;i<toAddress.length;i++) {
				message.addRecipient(Message.RecipientType.TO, toAddress[i]);
				
			}
			message.setSubject(subject);
			message.setText(message1);
			
			Transport transport = session.getTransport("smtp");
			transport.connect(host,from,pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			
		}
		catch(Exception e) {
			System.out.println("hata"+e);
		}
	}
}
