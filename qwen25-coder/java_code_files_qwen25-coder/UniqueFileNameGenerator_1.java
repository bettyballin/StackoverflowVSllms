import java.lang.String;
import java.io.File;
import java.security.SecureRandom;

public class UniqueFileNameGenerator_1 {

    private static final SecureRandom RANDOM = new SecureRandom();
    private static int count = 0; // Simple counter to handle same millisecond creation

    public static String generateUniqueFileName(String prefix, String suffix) {
        long timestamp = System.currentTimeMillis();
        int randomNum = RANDOM.nextInt(1000); // Random number for shorter filename
        return String.format("%s_%d_%d_%d%s", prefix, timestamp, randomNum, count++, suffix);
    }

    public static void main(String[] args) {
        String directoryPath = "/your/directory/path";
        File dir = new File(directoryPath);

        // Example usage
        String fileName = generateUniqueFileName("file", ".txt");
        File file = new File(dir, fileName);
        System.out.println("Generated filename: " + file.getAbsolutePath());
    }
}