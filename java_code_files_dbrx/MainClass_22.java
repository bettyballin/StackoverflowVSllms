import java.lang.String;
// Java Code Example: Garbage Collector in action as a high level language Memory Management Algorithm
public class MainClass_22 {
    public static void main(String[] args) {
        // Create an object, allocate it to heap space.
        Object obj = new Object();
        // Perform operations... then set it null (orphan), allowing GC to free memory used by the object.
        obj = null;
    }
}