public class ApplicationB {
    public static void main(String[] args) {
        // Assume 'operation' is received via some communication protocol
        Operation operation = null; // Received from Application A

        // Call the interface method without needing to know the implementation class
        operation.perform();
    }
}

interface Operation {
    void perform();
}