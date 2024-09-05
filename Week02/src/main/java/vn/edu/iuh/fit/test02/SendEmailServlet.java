package vn.edu.iuh.fit.test02;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.util.ByteArrayDataSource;

@WebServlet("/sendEmail")
@MultipartConfig
public class SendEmailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String recipient = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String messageContent = request.getParameter("message");
        Part filePart = request.getPart("attachment"); // File đính kèm

        // Email server configuration
        String host = "smtp.gmail.com";
        final String senderEmail = "huubangle20002@gmail.com"; // Đổi thành email của bạn
        final String senderPassword = "ekcsgwvqpenmehmo"; // Đổi thành mật khẩu email

        // Thiết lập các thuộc tính cho việc gửi email
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Tạo session với username và password
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Tạo email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);

            // Phần body của email (nội dung)
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(messageContent, "text/html");

            // Tạo multipart cho email
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            // Nếu có file đính kèm
            if (filePart != null && filePart.getSize() > 0) {
                MimeBodyPart attachmentPart = new MimeBodyPart();

                // Lấy InputStream từ file được upload
                InputStream inputStream = filePart.getInputStream();

                // Tạo DataSource từ InputStream và loại nội dung của file
                DataSource dataSource = new ByteArrayDataSource(inputStream, filePart.getContentType());

                // Gắn DataSource vào phần đính kèm
                attachmentPart.setDataHandler(new DataHandler(dataSource));
                attachmentPart.setFileName(filePart.getSubmittedFileName()); // Đặt tên file

                multipart.addBodyPart(attachmentPart);
            }

            // Thiết lập nội dung email
            message.setContent(multipart);

            // Gửi email
            Transport.send(message);

            // Phản hồi sau khi gửi email thành công
            request.setAttribute("message", "Email has been sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
            request.setAttribute("message", "Failed to send email: " + e.getMessage());
        }

        // Chuyển đến trang thông báo
        getServletContext().getRequestDispatcher("/messageEmail.jsp").forward(request, response);
    }
}
