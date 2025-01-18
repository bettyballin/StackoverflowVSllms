import java.lang.String;

public class MyLegacyClass {
    private final String jndiName;

    public MyLegacyClass(MyConfig config) {
        this.jndiName = config.getJndiName();
    }

    // ... rest of the class's code goes here

    public static void main(String[] args) {
        // Example usage to ensure the code compiles
        MyConfig config = new MyConfig();
        MyLegacyClass legacyClass = new MyLegacyClass(config);
    }
}

// Minimal MyConfig class to allow compilation
class MyConfig {
    public String getJndiName() {
        return "defaultJndiName";
    }
}