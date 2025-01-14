public class ArrayOutOfBoundsExceptionHandler {
    int index = externalInput(); // Assume externalInput() is from an untrusted source
    Object[] array = new Object[10];

    { // Instance initializer block
        array[index] = "some value"; // If index >= 10 or < 0, this could throw ArrayIndexOutOfBoundsException
    }

    public int externalInput() {
        // For the purposes of this example, return a sample index (e.g., 0)
        return 0;
    }

    public static void main(String[] args) {
    }
}