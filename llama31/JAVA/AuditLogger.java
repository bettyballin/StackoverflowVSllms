import java.lang.String;
import java.util.logging.Logger;

public class AuditLogger {
    private static final Logger logger = Logger.getLogger(AuditLogger.class.getName());

    public void logEvent(String eventType, String message) {
        logger.info(String.format("%s: %s", eventType, message));
    }

    public void logDataModification(String dataId, String modificationType) {
        logEvent("DATA_MODIFICATION", String.format("Data ID: %s, Modification type: %s", dataId, modificationType));
    }

    public void logSystemChange(String changeType, String description) {
        logEvent("SYSTEM_CHANGE", String.format("Change type: %s, Description: %s", changeType, description));
    }

	public static void main(String[] args) {
	}
}