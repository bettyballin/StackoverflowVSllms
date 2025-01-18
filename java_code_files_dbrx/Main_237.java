import java.lang.String;
public class Main_237 {
    static Object obj; // Without a volatile modifier shared objects can cause race condition and reordering issue since threads may cache the variable value in their local memory space causing other threads not seeing updated values. Hence, to avoid this problem one needs proper synchronization or use of volatile keyword etc.

    public static void main(String[] args) {
        new Thread(() -> obj = new Object()).start(); // Constructor may still be running even after object is seen as non-null on other threads due to reordering issue! Hence, it's a best practice to make sure construction of objects are done within private scope or use the mentioned ways for synchronization.
        try {Thread.sleep(10);} catch (Exception e) {} // sleep for 10ms just so we can see our output before program exits...
        System.out.println("Our object is null = " + (obj == null)); // Will print false if constructor finishes but not necessarily otherwise due to possible visibility issues, reordering etc.
    }
}