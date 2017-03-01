/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




/**
 *
 * @author Yori
 */
public class sendMail {
    String host="localhost";  
    final String user="vanloo38@gmail.com";//change accordingly  
    String to="yori_vanloo@live.nl";//change accordingly 
    
    Properties props;
    
    Session session;
        
    public sendMail(){
       

        //Get the session object  
        props = new Properties();  
        props.put("mail.smtp.host",host);  
        props.put("mail.smtp.auth", "false");

        session = Session.getDefaultInstance(props, null);
        session.setDebug(true);
        
       

    }
    public void send(){
         try {
             Message msg = new MimeMessage(session);

            //Set message attributes
            msg.setFrom(new InternetAddress(user));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("Test E-Mail through Java");

            //send the message
            Transport.send(msg);

            System.out.println("message sent successfully...");
        }
        catch (MessagingException e) {e.printStackTrace();}
    }
  
}
