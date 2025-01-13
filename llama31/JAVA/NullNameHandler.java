import java.lang.String;

public class NullNameHandler {
    // Example of secure null handling in Java
    public static void main(String[] args) {
        String name = null;
        if (name == null) {
            System.out.println("Name is unspecified");
        } else if (name.isEmpty()) {
            System.out.println("Name is empty");
        }
    }
}