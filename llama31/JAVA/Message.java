import javax.persistence.SequenceGenerator;

public class Message {
    @SequenceGenerator(name = "messageSeq", sequenceName = "message_seq", allocationSize = 100)
    public static void main(String[] args) {
        // Empty main method to make the class executable
    }
}