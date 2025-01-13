import javax.mail.Flags;
import javax.mail.Message;
import javax.mail.MessagingException;

public class MessageProcessor {
    public static void main(String[] args) throws MessagingException {
        Message[] messages = new Message[] {/* initialize messages array */};
        for (int i = 0; i < messages.length; i++) {
            messages[i].setFlag(Flags.Flag.SEEN, true);
        }
    }
}