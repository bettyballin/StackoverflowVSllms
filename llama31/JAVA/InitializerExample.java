// Define the SomeClass
class SomeClass {
}

public class InitializerExample {
    SomeClass someObject = null;

    // Initialize someObject in a constructor
    public InitializerExample() {
        someObject = new SomeClass();
    }

    public static void main(String[] args) {
        // Create an instance of InitializerExample to trigger initialization
        InitializerExample example = new InitializerExample();
    }
}