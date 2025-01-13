import java.util.UUID;
import java.util.HashMap;
import java.util.Map;

// Simulate a basic HttpSession for demonstration purposes
class HttpSession {
    private Map<String, Object> attributes = new HashMap<>();

    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    public Object getAttribute(String name) {
        return attributes.get(name);
    }
}

public class StatefulService {
    private HttpSession session;

    public StatefulService() {
        // Manually instantiate HttpSession for this example
        this.session = new HttpSession();
    }

    public String startConversation(String message) {
        // Initialize conversation state
        session.setAttribute("conversationId", UUID.randomUUID().toString());
        return "Conversation started with message: " + message;
    }

    public String continueConversation(String message) {
        // Retrieve conversation state
        String conversationId = (String) session.getAttribute("conversationId");
        if (conversationId == null) {
            return "No conversation to continue.";
        }
        return "Continuing conversation " + conversationId + " with message: " + message;
    }

    public static void main(String[] args) {
        StatefulService service = new StatefulService();
        System.out.println(service.startConversation("Hello!"));
        System.out.println(service.continueConversation("How are you?"));
    }
}