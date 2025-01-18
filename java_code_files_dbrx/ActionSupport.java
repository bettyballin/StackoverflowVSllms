import java.lang.String;

public class ActionSupport {
    public static final String INPUT = "input";
    public static final String SUCCESS = "success";

    public void addActionError(String message) {
        System.out.println("Action Error: " + message);
    }

    public void addActionMessage(String message) {
        System.out.println("Action Message: " + message);
    }

    public String createAccount() {
        try {
            // Your database code, e.g., session.save(user);
        } catch (ConstraintViolationException e) {
            addActionError("Username already exists. Please choose another username.");
            return INPUT; // Show form again with the action error displayed to the user.
        } catch (RuntimeException e) {
            throw new ActionExecutionException(e); // Log and display a generic message for other exceptions.
        }
        addActionMessage("Account created successfully!");
        return SUCCESS;
    }

    public static void main(String[] args) {
        // You can call createAccount() here if needed.
    }
}

class ActionExecutionException extends RuntimeException {
    public ActionExecutionException(Throwable cause) {
        super(cause);
    }
}

class ConstraintViolationException extends RuntimeException {
    public ConstraintViolationException(String message) {
        super(message);
    }
}