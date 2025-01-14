import java.lang.String;
public class CapabilitiesConfigurator {
    static Options options = new Options();
    static {
        options.setCapability("unhandledPromptBehavior", "dismiss");
    }
    public static void main(String[] args) {
    }
}

class Options {
    public void setCapability(String key, String value) {
        // Implementation here
    }
}