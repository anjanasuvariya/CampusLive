package admin.action;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
/**
  * A simple email sender class.
  */
public class SimpleMailSender
{
  /**
    * Main method to send a message given on the command line.
    */
  public static void main(String args[])
  {
    try{
        
        System.out.println("Starting to send...");
      String host = "smtp.gmail.com";
    String from = "jyotpatel.imnu@gmail.com";
    String pass = "$power1$";
    Properties props = System.getProperties();
    props.put("mail.smtp.starttls.enable", "true"); // added this line
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.user", from);
    props.put("mail.smtp.password", pass);
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");
 
    String[] to = {"anjanasuvariya@gmail.com","sachin.suvariya292@gmail.com"}; // added this line
 
    Session session = Session.getDefaultInstance(props, null);
    MimeMessage message = new MimeMessage(session);
    message.setFrom(new InternetAddress(from));
 
    InternetAddress[] toAddress = new InternetAddress[to.length];
 
    // To get the array of addresses
    System.out.println("Now getting To");
    for( int i=0; i < to.length; i++ ) { // changed from a while loop
        toAddress[i] = new InternetAddress(to[i]);
    }
    System.out.println(Message.RecipientType.TO);
 
    for( int i=0; i < toAddress.length; i++) { // changed from a while loop
        message.addRecipient(Message.RecipientType.TO, toAddress[i]);
    }
    System.out.println("Hey");
    message.setSubject("Hi ");
    message.setText("hi....thr??..");
    Transport transport = session.getTransport("smtp");
    System.out.println("Now Connecting");
    transport.connect(host, from, pass);
    System.out.println("Connected");
    transport.sendMessage(message, message.getAllRecipients());
    transport.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }
    }
}