import java.util.Map;
import java.util.HashMap;

public class MyClass {
    public static void main(String[] args) {
        Map<String, String> processedMessages = new HashMap<>(); // Save the UID for each already processed msg

        Message[] messages = getMessagesFromSomewhere();

        for (int i = 0; i < messages.length; i++) {
            // check if this mail was already processed or not here:
            if(!processedMessages.containsKey(messages[i].getUID())) {
                // Process your message and mark it as 'Recent' flag false after processing
                messages[i].setFlag(new Flags.Flag(), "\\Seen", true);
                processedMessages.put(messages[i].getUID(), "");
            }
        }
    }

    static Message[] getMessagesFromSomewhere() {
        // For demonstration purposes, return an array with a single message
        return new Message[] { new Message() };
    }
}

// Dummy Message class
class Message {
    public String getUID() {
        return "dummyUID";
    }

    public void setFlag(Object flagType, String flagValue, boolean value) {
        // Implementation goes here
    }
}

// Dummy Flags class
class Flags {
    static class Flag {
        // Implementation goes here
    }
}