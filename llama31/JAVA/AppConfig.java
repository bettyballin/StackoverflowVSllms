import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// application-configuration
@Configuration
public class AppConfig {
    @Bean
    public UrlGenerator urlGenerator() {
        return new UrlGeneratorImpl();
    }

    public static void main(String[] args) {
    }
}

// Assuming UrlGenerator and UrlGeneratorImpl are defined elsewhere
// If not, you need to define them as well
interface UrlGenerator {
    // methods
}

class UrlGeneratorImpl implements UrlGenerator {
    // implementation
}