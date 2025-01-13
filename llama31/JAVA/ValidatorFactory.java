import java.lang.String;

public class ValidatorFactory {
    public static <T> AbstractValidator<T> getValidator(T object) {
        Class<?> clazz = object.getClass();
        String validatorClassName = clazz.getSimpleName() + "Validator";
        try {
            Class<?> validatorClass = Class.forName(validatorClassName);
            return (AbstractValidator<T>) validatorClass.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Validator not found for class " + clazz.getName(), e);
        }
    }

    public static void main(String[] args) {
    }
}

// Added the missing AbstractValidator class
abstract class AbstractValidator<T> {
    // Add your validation logic here
}