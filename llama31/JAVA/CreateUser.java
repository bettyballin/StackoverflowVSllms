import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

// Define the DSL class
class CreateUser {
    private final String user;
    private String email;
    private String password;

    public CreateUser(String user) {
        this.user = user;
    }

    public void withEmail(String email) {
        this.email = email;
    }

    public String andPassword(String password) {
        this.password = password;
        return password; // Return a value to match the method signature
    }
}

// Parser implementation
class Parser {
    private static final Map<String, MethodHandle> dslMethods = new HashMap<>();

    static {
        try {
            // Register DSL methods
            dslMethods.put("CreateUser", MethodHandles.lookup().findConstructor(CreateUser.class, String.class));
            dslMethods.put("withEmail", MethodHandles.lookup().findVirtual(CreateUser.class, "withEmail", String.class));
            dslMethods.put("andPassword", MethodHandles.lookup().findVirtual(CreateUser.class, "andPassword", String.class));
        } catch (Exception e) {
            // Handle errors
        }
    }

    public void parse(String input) {
        String[] sentences = input.split("\\.");
        for (String sentence : sentences) {
            String[] tokens = sentence.split("\\s+");
            String className = tokens[0];
            MethodHandle methodHandle = dslMethods.get(className);

            if (methodHandle != null) {
                // Invoke the method with the remaining tokens as arguments
                try {
                    Object instance = methodHandle.invokeWithArguments(tokens[1]);
                    // Process the instance (e.g., call JUnit test methods)
                    System.out.println(instance);
                } catch (Throwable e) {
                    // Handle errors
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        String input = "CreateUser user1 with email test@email.com and password test.";
        parser.parse(input);
    }
}