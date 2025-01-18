import java.util.List;

public class NullSafeListChecker {
    public static void main(String[] args) {
        Object object = null; // Initialize 'object' as needed

        if (object != null && object.getClass().getName().startsWith("java.util.List")) { 
            // This checks that the object isn't null before checking if it’s of type java.util.List.
            // Your logic here...
        }
    }
}