/*
 * Decompiled with CFR 0.152.
 */
import java.util.logging.Logger;

public class AuditLogger {
    private static final Logger logger = Logger.getLogger(AuditLogger.class.getName());

    public void logEvent(String string, String string2) {
        logger.info(String.format("%s: %s", string, string2));
    }

    public void logDataModification(String string, String string2) {
        this.logEvent("DATA_MODIFICATION", String.format("Data ID: %s, Modification type: %s", string, string2));
    }

    public void logSystemChange(String string, String string2) {
        this.logEvent("SYSTEM_CHANGE", String.format("Change type: %s, Description: %s", string, string2));
    }

    public static void main(String[] stringArray) {
    }
}
