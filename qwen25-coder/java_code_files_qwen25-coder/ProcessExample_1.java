// Example of safe method invocation
public class ProcessExample {
    public void processObject(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Argument 'obj' must not be null");
        }
        // Proceed with using 'obj'
        System.out.println("Processing object: " + obj);
    }
    
    // Usage
    public static void main(String[] args) {
        Object someObject = null; // This will cause IllegalArgumentException

        ProcessExample example = new ProcessExample();

        try {
            example.processObject(someObject);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }
}