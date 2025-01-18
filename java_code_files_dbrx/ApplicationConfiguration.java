import java.lang.annotation.*;

// Annotations
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Configuration {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Bean {}

// Classes and interfaces
class Clock {
    public static final Clock SYSTEM = new Clock();
}

class CollectorRegistry {
    public static final CollectorRegistry defaultRegistry = new CollectorRegistry();
}

interface PrometheusConfig {
    PrometheusConfig DEFAULT = new PrometheusConfig() {
        // Default implementation (can be empty for this stub)
    };
}

class PrometheusMeterRegistry {
    public PrometheusMeterRegistry(PrometheusConfig config, CollectorRegistry registry, Clock clock) {
        // Constructor body
    }
}

@Configuration
public class ApplicationConfiguration {
    @Bean
    public PrometheusMeterRegistry prometheusRegistry() {
        return new PrometheusMeterRegistry(
            PrometheusConfig.DEFAULT,
            CollectorRegistry.defaultRegistry,
            Clock.SYSTEM
        );
    }
}