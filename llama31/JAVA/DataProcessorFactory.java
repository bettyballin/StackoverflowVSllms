import java.lang.String;

// Flexible, low-level API
public interface DataProcessor {
    void process(Data data);
}

// Data class, assumed to be missing in the original code
class Data {
    // Add fields and methods as necessary
}

// Configuration class, assumed to be missing in the original code
class Configuration {
    // Add fields and methods as necessary
}

// DefaultDataProcessor class, assumed to be missing in the original code
class DefaultDataProcessor implements DataProcessor {
    @Override
    public void process(Data data) {
        // Implement default processing logic here
    }
}

// CustomDataProcessor class, assumed to be missing in the original code
class CustomDataProcessor implements DataProcessor {
    private Configuration config;

    public CustomDataProcessor(Configuration config) {
        this.config = config;
    }

    @Override
    public void process(Data data) {
        // Implement custom processing logic based on the provided configuration
    }
}

// High-level, ease-of-use API
public class DataProcessorFactory {
    public static DataProcessor createDefaultProcessor() {
        // Create a pre-configured processor with sensible defaults
        return new DefaultDataProcessor();
    }

    public static DataProcessor createCustomProcessor(Configuration config) {
        // Create a custom processor based on the provided configuration
        return new CustomDataProcessor(config);
    }

    public static void main(String[] args) {
        Data data = new Data(); // Create a Data instance
        DataProcessor processor = DataProcessorFactory.createDefaultProcessor();
        processor.process(data);
    }
}