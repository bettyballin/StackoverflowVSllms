import java.lang.String;
import java.lang.HashMap;
import java.lang.Map;

public interface MyAccountService {
    void create(String user) throws AccountCreationException;
}

public class AccountCreationException extends Exception {
    private final Map<String, Throwable> errors = new HashMap<>();

    public void addError(String step, Throwable throwable) {
        this.errors.put(step, throwable);
    }

    public Map<String, Throwable> getErrors() {
        return errors;
    }

    @Override
    public String getMessage() {
        StringBuilder message = new StringBuilder();
        for (Map.Entry<String, Throwable> entry : errors.entrySet()) {
            message.append("Step: ").append(entry.getKey())
                   .append(", Error: ").append(entry.getValue().getMessage())
                   .append("\n");
        }
        return message.toString();
    }
}

// Usage
public class MainClass {

    private MyAccountService myAccountService;

    public void handleUserCreation(String user) {
        try {
            myAccountService.create(user);
            System.out.println("User creation successful.");
        } catch (AccountCreationException e) {
            System.err.println("User creation failed:");
            for (Map.Entry<String, Throwable> error : e.getErrors().entrySet()) {
                System.err.println(error.getKey() + ": " + error.getValue().getMessage());
            }
            // Log or handle exceptions as necessary
        }
    }

    public static void main(String[] args) {
    }
}