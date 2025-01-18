public class Debug {
    private static final boolean DEBUG = false; // Set to true for debug mode

    public static void Assert(boolean condition, String message) {
        if (DEBUG && !condition) {
            throw new AssertionError(message);
        }
        // In release mode, do nothing
    }

    // Usage
    public static void main(String[] args) {
        Object val = null;
        Debug.Assert(val != null, "mesasage");
        // In release mode nothing will happen if val == null. No error message, no halt, etc.
        // So this might not be the best approach.
    }
}