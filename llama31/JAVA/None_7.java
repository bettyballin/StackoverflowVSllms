public class None_7_7 {
    private static boolean debugMode = System.getProperty("java.debug") != null;
    private static boolean releaseMode = !debugMode;

    public static void main(String[] args) {
        if (debugMode) {
            // Debug mode
        } else {
            // Release mode
        }
    }
}