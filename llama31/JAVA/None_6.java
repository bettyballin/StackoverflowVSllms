public class None_6_6 {
    public static void main(String[] args) {
        boolean debugMode = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().contains("-agentlib:jdwp");
        boolean releaseMode = !debugMode;
        if (debugMode) {
            // Debug mode
        } else {
            // Release mode
        }
    }
}