import java.lang.String;

public class Object_1_1 {
    // ...
    private int identityHashCode; // stored in the object header

    public Object_1() {
        // Calculate and store the identity hash code
        identityHashCode = calculateIdentityHashCode();
    }

    public int hashCode() {
        // By default, return the pre-calculated identity hash code
        return identityHashCode;
    }

    private int calculateIdentityHashCode() {
        // Implementation-specific calculation, possibly based on memory address
        // For demonstration purposes, a simple implementation is provided
        return System.identityHashCode(this);
    }

    public static void main(String[] args) {
        Object_1 obj = new Object_1();
        System.out.println(obj.hashCode());
    }
}