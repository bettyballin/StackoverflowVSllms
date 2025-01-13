import java.lang.String;

public class SystemPropertyTest_1_1 {
    public static void main(String[] args) {
        System.setProperty("my.property", "value1");
        System.out.println(System.getProperty("my.property")); // prints "value1"

        // Create a new VM instance
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), "SystemPropertyTest_1");
        try {
            Process p = pb.start();
        } catch (Exception e) {
            System.out.println("Error starting new VM instance");
        }

        // The new VM instance will not inherit the system property
        System.out.println(System.getProperty("my.property")); // still prints "value1"
    }
}