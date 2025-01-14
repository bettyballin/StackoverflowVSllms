import java.util.ArrayList;
import java.util.List;

public class MyValidator {

    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        List<FacesMessage> messages = new ArrayList<>();

        // Assuming you have multiple conditions to check and add messages for different components
        boolean hasError1 = false; // your condition
        if (hasError1) {
            FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error 1", "This is the first error message.");
            context.addMessage("componentIdOne", msg1); // Add a client ID for the component
            messages.add(msg1);
        }

        boolean hasError2 = false; // your condition
        if (hasError2) {
            FacesMessage msg2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error 2", "This is the second error message.");
            context.addMessage("componentIdTwo", msg2); // Add a client ID for the component
            messages.add(msg2);
        }

        // If there are any errors, throw a ValidatorException which can contain logic to handle the batch of messages
        if (!messages.isEmpty()) {
            throw new ValidatorException(messages.get(0)); // Optionally throw an exception with one message as a convention
        }
    }
}

// Minimal stub classes to allow compilation

class FacesMessage {
    public static final Object SEVERITY_ERROR = new Object();

    private Object severity;
    private String summary;
    private String detail;

    public FacesMessage(Object severity, String summary, String detail) {
        this.severity = severity;
        this.summary = summary;
        this.detail = detail;
    }
}

class FacesContext {
    public void addMessage(String componentId, FacesMessage message) {
        // Minimal implementation
    }
}

class UIComponent {
    // Minimal implementation
}

class ValidatorException extends Exception {
    public ValidatorException(FacesMessage message) {
        super();
    }
}