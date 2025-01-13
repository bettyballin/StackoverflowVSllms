import java.util.Vector;

public class MyClass_13_13 {
    private Vector<Integer> vec = new Vector<>();
    private int value; // Added missing variable declaration

    public void someMethod() {
        synchronized (vec) {
            for (int i = 0; i < vec.size(); i++) {
                vec.set(i, vec.get(i) + value);
            }
        }
    }

    public static void main(String[] args) {
        // Empty main method, but still required for the class to be executable
    }
}