class SomeClass {
    // You can add fields and methods as needed
}

public class Main {
    public static void main(String[] args) {
        // Assume SomeClass is some custom class that we're using
        SomeClass obj = new SomeClass(); // Create a new object
        obj = null; // Set the reference to null, making it immediately eligible for GC
    }
}