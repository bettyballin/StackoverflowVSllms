import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;

public class Main_641 {
    public static void main(String[] args) throws MessagingException, IOException {
        // Create a multipart
        Multipart multipart = new MimeMultipart();

        // Add an embedded image
        MimeBodyPart imagePart = new MimeBodyPart();
        imagePart.attachFile("path/to/image.png");
        imagePart.setDisposition(MimeBodyPart.INLINE);
        imagePart.setContentID("<image.png>");
        multipart.addBodyPart(imagePart);
    }
}