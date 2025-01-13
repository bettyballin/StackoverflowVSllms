import java.lang.String;

public class DebugModeChecker {
    public static void main(String[] args) {
        String debugMode = System.getProperty("debug.mode", "false");

        if (!Boolean.parseBoolean(debugMode)) {
            // Do something()
            System.out.println("Not in debug mode");
        } else {
            System.out.println("In debug mode");
        }
    }
}