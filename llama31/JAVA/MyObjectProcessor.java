// Define the MyObject class
class MyObject {
    // Add properties and methods as needed
}

public class MyObjectProcessor {
    /**
     * Processes the input object without modifying it.
     */
    public void process(final MyObject obj) {
        // ...
    }

    public static void main(String[] args) {
        // Create an instance of MyObjectProcessor
        MyObjectProcessor processor = new MyObjectProcessor();

        // Create an instance of MyObject
        MyObject obj = new MyObject();

        // Process the object
        processor.process(obj);
    }
}