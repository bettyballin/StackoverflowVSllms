import javax.mail.Flags;
import javax.mail.Message;

public class EmailProcessor {
    public static void main(String[] args) {
        Message[] messages = new Message[1]; // Assuming messages is an array of Message objects
        try {
            messages[0].setFlag(new Flags("PROCESSED"), true);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}