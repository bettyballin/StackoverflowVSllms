import java.lang.String;
// Example of detailed logging using SLF4J and Logback
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyClass_21 {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyClass_21.class);

    public void criticalOperation() {
        try {
            // Some operation
            LOGGER.debug("Critical operation performed successfully.");
        } catch (Exception e) {
            LOGGER.error("Error performing critical operation.", e);
        }
    }

    public static void main(String[] args) {
    }
}