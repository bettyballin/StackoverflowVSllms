import java.lang.String;

@Configuration
public class ResourceConfig {
    @Bean("productionResourceLoader")
    public IDataReader produceProdResource() {
        return new DefaultDataReader(); // Production resource reader.
    }
}

// Test-specific configuration for tests only, with its own qualified bean names:
@Profile("test")
public class ResourceConfigTest {
    @Bean("testResourceLoader")
    public IDataReader produceTestResource() {
        return new TestDataReader(); // Mock test data reader.
    }

    public static void main(String[] args) {
    }
}

@interface Configuration {}

@interface Bean {
    String value() default "";
}

@interface Profile {
    String value() default "";
}

interface IDataReader {
    void readData();
}

class DefaultDataReader implements IDataReader {
    public void readData() {
        // Implementation here
    }
}

class TestDataReader implements IDataReader {
    public void readData() {
        // Mock implementation here
    }
}