// Define a simple Authenticator class
class Authenticator {
    public boolean authenticate(String username, String password) {
        // Simple authentication logic for demonstration purposes
        return username.equals("user123") && password.equals("pass123");
    }
}

// Component (a single Lego brick)
class Logger {
    public void log(String message) {
        System.out.println(message); // Simple logging logic
    }
}

// Module (a Lego structure composed of multiple bricks)
public class SecurityModule {
    private Logger logger;
    private Authenticator authenticator;

    public SecurityModule(Logger logger, Authenticator authenticator) {
        this.logger = logger;
        this.authenticator = authenticator;
    }

    public void authenticate(String username, String password) {
        logger.log("Authentication attempt");
        if (authenticator.authenticate(username, password)) {
            logger.log("Authentication successful");
        } else {
            logger.log("Authentication failed");
        }
    }

    public static void main(String[] args) {
        Logger logger = new Logger();
        Authenticator authenticator = new Authenticator();
        SecurityModule securityModule = new SecurityModule(logger, authenticator);
        
        securityModule.authenticate("user123", "pass123"); // Should log a successful authentication
        securityModule.authenticate("wrongUser", "wrongPass"); // Should log a failed authentication
    }
}