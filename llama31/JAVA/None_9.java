public class None_9_9 {
    public static void main(String[] args) {
        boolean debugMode = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().contains("jdwp");
        boolean releaseMode = !debugMode;
        if (debugMode) {
            // Debug mode
            System.out.println("Debug mode");
        } else {
            // Release mode
            System.out.println("Release mode");
        }
    }
}