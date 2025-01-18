// Set configurations
public class Main {
    public static final boolean DEV_MODE = false; // Change to true during testing/debugging phase
    private Configuration RELEASE = new Configuration("Release");    // Release Build Configurations
    private Configuration TESTING = new Configuration("Testing");    // Development Testing build conf.
    private Configuration DEBUG = new Configuration("Debug");        // Debugging build configurations

    public void run() {
        // Configure switch statement for conditional compiling based on DEV_MODE constant
        if (DEV_MODE) {
            configure(DEBUG);
        } else {
            configure(RELEASE);
        }
    }

    public void configure(Configuration config) {
        // Configuration logic here
        System.out.println("Configuring for: " + config.getName());
    }

    public static void main(String[] args) {
        new Main().run();
    }
}

class Configuration {
    private String name;

    public Configuration(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}