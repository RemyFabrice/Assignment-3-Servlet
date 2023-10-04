package srcpackage3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@WebServlet("/ConfirmationServlet")
public class ConfirmationMailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String recipientEmail = request.getParameter("email");

        
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "192.168.1.1"); //SMTP Server host
        properties.put("mail.smtp.port", "587"); // port

        
        final String username = "niyobfabinox@example.com"; // email address
        final String password = "password@2023?"; // email password

        
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); 
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Confirmation Email");
            message.setText("Successfully Email sent");

            
            Transport.send(message);

            
            response.getWriter().println("email sent successfully.");
        } catch (MessagingException e) {
            
            response.getWriter().println("Error: Unable to send email.");
            e.printStackTrace();
        }
    }
}
