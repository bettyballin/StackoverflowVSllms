import java.util.UUID;

public class Main_643 {
    public static void main(String[] args) {
        // Generate a random UUID token
        String token = UUID.randomUUID().toString();

        // Store the token as an alternate key in your database
        System.out.println(token);
    }
}