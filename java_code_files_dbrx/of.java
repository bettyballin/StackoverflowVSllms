import java.lang.String;
import java.lang.reflect.*;

public class of {
    public <T> AbstractValidator<T> getValidator(T obj) throws Exception {
        Class<?> clazz = obj.getClass(); // Get the runtime class of the input object e.g., Customer or Cat
        String validatorClassName = "com." + clazz.getSimpleName() + "Validator";  // Generate a package name and add it to the validator class, assumes all validators are inside com.* packages

        Class<?> validatorClass = Class.forName(validatorClassName); // Find the validator class using reflection

        Constructor<?> constructor = validatorClass.getDeclaredConstructor();  // Fetch the default no-arg constructor of the found class through reflection
        Object instance = constructor.newInstance();  // Create a new instance via the retrieved constructor, and store in an `Object` variable

        // Cast and return the instantiated object to AbstractValidator<T> type
        return (AbstractValidator<T>) instance;
    }

    public static void main(String[] args) {
    }
}

abstract class AbstractValidator<T> {
    // Abstract class definition
}