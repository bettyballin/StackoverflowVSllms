import java.lang.String;
public class MyClass_4 {
    private int m_myValue;

    public final int GetMyValue() {
        // This is already optimal for returning primitives.
        return m_myValue;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        MyClass_4 instance = new MyClass_4();
        instance.m_myValue = 10;
        for (int i = 0; i < 1000000; i++) { // Example loop
            int value = instance.GetMyValue();
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }
}