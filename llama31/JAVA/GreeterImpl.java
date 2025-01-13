// Define the Greeter interface
interface Greeter {
    void greet(String name);
}

// Implement the Greeter interface
class GreeterImpl implements Greeter {
    @Override
    public void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

// Main class to test the Greeter service
public class Main {
    public static void main(String[] args) {
        // Directly instantiate the Greeter implementation
        Greeter greeter = new GreeterImpl();
        // Use the greeter service
        greeter.greet("John");
    }
}