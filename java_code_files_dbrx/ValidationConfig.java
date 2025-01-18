import java.lang.String;

@Configuration
public class ValidationConfig {
    @Bean("messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource bundle = new ResourceBundleMessageSource();
        bundle.setBasenames("ValidationMessages"); // Your resource messages file.
        return bundle;
    }

    public static void main(String[] args) {
    }
}

// Necessary annotations and classes (stubs for compilation)

@interface Configuration {
}

@interface Bean {
    String value();
}

interface MessageSource {
}

class ResourceBundleMessageSource implements MessageSource {
    public void setBasenames(String basename) {
        // Implementation here
    }
}