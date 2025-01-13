public class ContextManager {
    public static void main(String[] args) {
        // Declare and initialize myVariable and engine
        String myVariable = "Hello, World!";
        java.util.HashMap<String, Object> engine = new java.util.HashMap<>();
        engine.put("myVariable", myVariable);
        System.out.println(engine.get("myVariable")); // prints "Hello, World!"
    }
}