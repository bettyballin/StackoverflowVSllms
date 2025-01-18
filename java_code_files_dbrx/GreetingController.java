// Annotations

@interface Controller {
}

@interface MessageMapping {
    String value();
}

@interface SendTo {
    String value();
}

// HtmlUtils class

class HtmlUtils {
    public static String htmlEscape(String input) {
        // For simplicity, just return the input string.
        // In a real application, this should escape HTML special characters.
        return input;
    }
}

// HelloMessage class

class HelloMessage {
    private String message;

    public HelloMessage(String message) {
        this.message = message;
    }

    // Getter and Setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

// Main class

@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public HelloMessage greeting(String message) throws Exception {
        Thread.sleep(100); // simulated delay because of layout loading...
        return new HelloMessage("Hello, " + HtmlUtils.htmlEscape(message) + "!");
    }

    public static void main(String[] args) {
    }
}