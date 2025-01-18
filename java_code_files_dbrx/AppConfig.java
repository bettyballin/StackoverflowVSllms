import java.lang.String;

@interface Configuration {
}

@interface Bean {
    String initMethod() default "";
}

public class AppConfig {
    @Bean(initMethod = "afterPropertiesSet")
    public SomeModule someService(PresentationLayerUrlGenerator generator) {
        SomeModule sc = new SomeModule();  // Assuming no-args constructor of SomeModule exists
        sc.setUrlGenerator(generator);
        return sc;
    }

    public static void main(String[] args) {
    }
}

class SomeModule {
    public SomeModule() {
        // No-args constructor
    }

    public void setUrlGenerator(PresentationLayerUrlGenerator generator) {
        // Implementation here
    }
}

interface PresentationLayerUrlGenerator {
    // Interface definition
}