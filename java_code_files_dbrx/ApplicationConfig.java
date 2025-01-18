// Stub class for ResourceConfig
class ResourceConfig {
    public void register(Class<?> componentClass) {
        // Empty implementation
    }
}

public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig() {
        // ... other configuration stuff here ..
        register(GenericExceptionMapper.class);
    }
}

// Stub class for GenericExceptionMapper
class GenericExceptionMapper {
    // Empty class
}