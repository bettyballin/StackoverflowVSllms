import java.lang.String;
// Java example
public class Hello {
    public static void main(String[] args) {
        System.gc(); // request garbage collection for cleaner state
        long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Hello World");
        long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Approximate memory used: " + (endMemory - startMemory) / 1024 + " KB");
    }
}