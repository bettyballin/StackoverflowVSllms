public class Main {
    public static void main(String[] args) {
        String componentName = "MyComponent"; // replace with your actual component name
        new ComponentTester().action(() -> componentName); // replace with your actual test action
    }
}

class ComponentTester {
    public void action(java.util.function.Supplier<String> s) {
        String result = s.get();
        // Do something with result if needed
    }
}