import java.lang.String;

public class Main_320_320 {
    public static void main(String[] args) {
        try {
            // Load the Preloader class
            Class.forName("com.example.Preloader");
            // Start your application
        } catch (ClassNotFoundException e) {
            System.err.println("Error loading Preloader class: " + e.getMessage());
        }
    }
}