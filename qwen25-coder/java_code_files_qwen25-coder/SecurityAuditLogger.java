import java.lang.String;
import java.util.logging.Logger;
import java.util.logging.Level;

public class SecurityAuditLogger {
    private static final Logger logger = Logger.getLogger(SecurityAuditLogger.class.getName());

    public void logAuthenticationEvent(String user, boolean success) {
        String message = "User '" + user + "' authentication attempt. Success: " + success;
        logger.log(success ? Level.INFO : Level.WARNING, message);
    }

    public void logAuthorizationFailure(String user, String resource) {
        String message = "User '" + user + "' authorization failure for resource '" + resource + "'.";
        logger.warning(message);
    }

    public void logSensitiveDataAccess(String user, String dataId, String action) {
        String message = "User '" + user + "' accessed sensitive data ID '" + dataId + "' with action: " + action;
        logger.info(message);
    }

    public void logConfigurationChange(String configName, String oldValue, String newValue, String user) {
        String message = "User '" + user + "' changed configuration '" + configName + "'. Old value: " + oldValue + ". New value: " + newValue;
        logger.warning(message);
    }

    // Add more methods for other events as necessary

	public static void main(String[] args) {
	}
}