import java.lang.String;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Define necessary annotations
@Retention(RetentionPolicy.RUNTIME)
@interface Configuration {
}

@Retention(RetentionPolicy.RUNTIME)
@interface Bean {
}

// Define the Validator interface
interface Validator {
}

// Simulate LocalValidatorFactoryBean class
class LocalValidatorFactoryBean implements Validator {
}

// Define the WebMvcConfigurer interface
interface WebMvcConfigurer {
    Validator getValidator();
}

// Define the WebMvcConfigurerAdapter abstract class
abstract class WebMvcConfigurerAdapter implements WebMvcConfigurer {
    public Validator getValidator() {
        return null;
    }
}

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

    @Override
    public Validator getValidator() {
        return validator();
    }

    public static void main(String[] args) {
    }
}