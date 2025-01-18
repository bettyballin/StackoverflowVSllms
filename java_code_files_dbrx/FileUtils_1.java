import java.lang.String;
import java.io.*;
import java.util.*;

public class FileUtils_1 {
    private static final String PREFIX = "file_";

    public static String getUniqueFileName(File directory, String suffix) {
        int counter = 0;
        while (counter < 100) { // Try a limited number of times to prevent infinite loop
            File file = new File(directory.getPath() + "/"
                    + PREFIX + getUniqueID() + "_" + suffix);
            if (!file.exists()) {
                return file.getAbsolutePath();
            }
            counter++; // If a collision occurred, increment the counter for the next iteration
        }
        // If after multiple attempts file still exists, throw an exception or handle as needed
        throw new RuntimeException("Could not generate unique filename.");
    }

    private static String getUniqueID() {
        return "pid" + System.identityHashCode(Thread.currentThread()) + "_"
                + System.nanoTime(); // Using nanoseconds to decrease the chances of collision when two files are generated at close timestamps
    }

	public static void main(String[] args) {
	}
}