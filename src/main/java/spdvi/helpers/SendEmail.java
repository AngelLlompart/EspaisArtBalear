/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spdvi.helpers;

import java.awt.Frame;
import java.util.Properties;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumne
 */
public class SendEmail {
    public void sendEmail(javax.swing.JTextField textField) {
        String password = PasswordGenerator.getPassword(
                PasswordGenerator.MINUSCULAS
                + PasswordGenerator.MAYUSCULAS
                + PasswordGenerator.ESPECIALES, 10);
        
        String correoRemitente = "interficies99@gmail.com";
        String passwordRemitente = "1234joan";
        String correoReceptor = textField.getText();
        String asunto = "El codi es:";
        String missatge = password;

        Pattern emailRegEx = Pattern.compile("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
        //comparam si la pagina web introduida compleix la expresio regular, si la compleix s'executa el menu, si no printa URL incorrecta i atura el programa
        if (emailRegEx.matcher(correoReceptor).matches()) {
            Properties props = System.getProperties();
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");  //El servidor SMTP de Google
            props.put("mail.smtp.user", correoRemitente);     // El correo del remitente
            props.put("mail.smtp.clave", passwordRemitente);  //La clave de la cuenta
            props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
            props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
            props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google
            System.setProperty("mail.smtp.ssl.protocols", "TLSv1.2"); //Solucionar el error de protocol

            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);
            try {
                message.setFrom(new InternetAddress(correoRemitente));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
                message.setSubject(asunto);
                message.setText(missatge);

                Transport transport = session.getTransport("smtp");
                transport.connect("smtp.gmail.com", correoRemitente, passwordRemitente);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();

                JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");
                //setVisible(false);
                //ConfirmPassword cP = new ConfirmPassword((Frame) this.getParent(), true);
                //cP.setVisible(true);
            } catch (AddressException ex) {
            } catch (MessagingException ex) {
            }
        } else if(!emailRegEx.matcher(correoReceptor).matches()) {
            JOptionPane.showMessageDialog(null, "El correo electonico introducido esta mal");
        }
    }
    
}
