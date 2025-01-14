import java.io.IOException;

public class FunctionAvailabilityCheck {
    public static void main(String[] args) {
        boolean isRuntimeExecAvailable = checkIfRuntimeExecIsAvailable();
        if (isRuntimeExecAvailable) {
            System.out.println("Runtime.exec() is available.");
        } else {
            System.out.println("Runtime.exec() is not available. Disabling related UI functionality.");
            // Disable or handle the unavailability of Runtime.exec()
        }
    }

    public static boolean checkIfRuntimeExecIsAvailable() {
        try {
            // Attempt to call the function
            Process process = Runtime.getRuntime().exec("java -version");
            // Optionally, you can read the process input stream to ensure it's running
            process.getInputStream();
            return true;
        } catch (SecurityException e) {
            // Catch SecurityException if the function is not allowed by security manager
            return false;
        } catch (IOException e) {
            // Handle other possible IO exceptions
            System.err.println("An I/O error occurred while trying to exec: " + e.getMessage());
            return false;
        }
    }
}