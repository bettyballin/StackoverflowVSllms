import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws MessagingException {
        // Sample byte array for the image
        byte[] imageByteArr = new byte[]{1, 2, 3, 4};

        // Create a mail session
        Session session = Session.getDefaultInstance(new Properties());

        // Create a MimeMessage
        MimeMessage mimeMessage = new MimeMessage(session);

        // Create a MimeMessageHelper with multipart support
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        // Add the inline image
        helper.addInline("cImage", new ByteArrayResource(imageByteArr));
    }
}

class ByteArrayResource {
    private byte[] byteArray;

    public ByteArrayResource(byte[] byteArray) {
        this.byteArray = byteArray;
    }
}

class MimeMessageHelper {
    private MimeMessage mimeMessage;
    private boolean multipart;

    public MimeMessageHelper(MimeMessage mimeMessage, boolean multipart) {
        this.mimeMessage = mimeMessage;
        this.multipart = multipart;
    }

    public void addInline(String contentId, ByteArrayResource resource) {
        // Stub method to make the code compile
    }
}