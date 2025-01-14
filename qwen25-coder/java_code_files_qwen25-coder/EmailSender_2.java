import org.springframework.core.io.ByteArrayResource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import java.io.UnsupportedEncodingException;

public class EmailSender {

    public void sendEmailWithInlineImage(JavaMailSender mailSender, String email, String body, String subject, byte[] imageByteArr) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("no-reply@example.com", "xyz");
        helper.setTo(email);
        helper.setText(body, true);
        helper.setSubject(subject);

        // Use ByteArrayResource instead of InputStreamResource
        ByteArrayResource resource = new ByteArrayResource(imageByteArr) {
            @Override
            public String getFilename() {
                return "inlineImage"; // Specify a filename here to avoid the error about missing file name.
            }
        };
        helper.addInline("cImage", resource);

        mailSender.send(message);
    }
}