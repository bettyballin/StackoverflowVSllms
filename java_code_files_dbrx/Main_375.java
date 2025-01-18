public class Main {
    public static void main(String[] args) {
        Dispatch events = new Dispatch("Events");
        events.put("Description", "Something happened");
        events.call("FireEvent"); // call a method or trigger event
    }
}

class Dispatch {
    private String name;
    private java.util.Map<String, Object> properties = new java.util.HashMap<>();

    public Dispatch(String name) {
        this.name = name;
    }

    public void put(String key, Object value) {
        properties.put(key, value);
    }

    public void call(String methodName) {
        // For demonstration, we'll just print the method name and properties
        System.out.println("Calling " + methodName + " on " + name);
        System.out.println("Properties: " + properties);
        // Actual method execution logic would go here
    }
}