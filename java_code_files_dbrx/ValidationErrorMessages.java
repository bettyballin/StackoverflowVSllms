import java.util.HashMap;
import java.util.Map;

public class ValidationErrorMessages {
    Map<String, String> errors = new HashMap<>();

    public ValidationErrorMessages() {
        errors.put("user.name.RequiredError", "User Name can't be empty");
        errors.put("email.FormatError", "Email not following valid format");
    }

    public static void main(String[] args) {
        ValidationErrorMessages vem = new ValidationErrorMessages();

        // later print the error or log it
        for (Map.Entry<String, String> entry : vem.errors.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}