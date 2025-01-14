import java.lang.String;
// Example of a simple Java program to illustrate garbage collection via software.
public class GarbageCollectionExample {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Object(); // Generate lots of objects to fill memory
        }
        System.gc(); // Suggest JVM to perform garbage collection
    }
}