import java.util.UUID;

public class Main_562 {
    public static void main(String[] args) {
        // Generate a unique identifier
        String uuid = UUID.randomUUID().toString();

        // Use the unique identifier in the URL
        String url = "/post/view/" + uuid;

        // Print the URL for verification
        System.out.println(url);
    }
}