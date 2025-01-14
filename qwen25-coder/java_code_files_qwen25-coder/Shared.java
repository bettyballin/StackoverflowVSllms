import java.io.IOException;

public final class Shared {
    // Static initializer to read default data
    static {
        try {
            initDefaultData();
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private Shared() {
        // Private constructor to prevent instantiation
    }

    private static void initDefaultData() throws IOException {
        // Your code to read default data from files
        if (false /* condition that indicates failure */) {
            throw new IOException("Failed to initialize default data.");
        }
    }

    public static boolean isInitializedSuccessfully() {
        return true;  // If the static initializer completes, initialization was successful.
    }

    // Other utility methods using the initialized data can go here
}