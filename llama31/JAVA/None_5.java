public class None_5_5 {
    public static void main(String[] args) {
        boolean debugMode = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().contains("jdwp");
        boolean releaseMode = !debugMode;
        if (debugMode) {
            // Debug mode
        } else {
            // Release mode
        }
    }
}