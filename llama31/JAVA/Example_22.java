import java.lang.String;
public class Example_22 {
    public static void main(String[] args) {
        // Create a large array
        byte[] largeArray = new byte[1024 * 1024 * 100]; // 100MB

        // Use the array for some time...
        // ...

        // Assign the array to null to help the garbage collector
        largeArray = null;

        // At this point, the garbage collector can collect the array
        // if it's no longer reachable from any other part of the application
    }
}