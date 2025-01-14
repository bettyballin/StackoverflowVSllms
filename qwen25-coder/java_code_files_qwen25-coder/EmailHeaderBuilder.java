import java.lang.String;

public class EmailHeaderBuilder {
    // Assuming 'message' is an instance of a Message class
    Message message = new Message();

    {
        message.addHeaderLine("Sender: support@example.com");
    }

    public static void main(String[] args) {
        // Main method remains empty as per original code
    }
}

// A simple Message class with the addHeaderLine method
class Message {
    public void addHeaderLine(String headerLine) {
        // Method implementation (can be left empty for compilation)
    }
}