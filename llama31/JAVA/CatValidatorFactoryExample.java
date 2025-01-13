// Define the Cat class
class Cat {
    // Simple class for demonstration
    private String name;

    public Cat() {
        this.name = "Default Cat";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// AbstractValidator interface
interface AbstractValidator<T> {
    boolean isValid(T object);
}

// ValidatorFactory class
class ValidatorFactory {
    public static <T> AbstractValidator<T> getValidator(T object) {
        // For demonstration, returns a simple validator
        return new AbstractValidator<T>() {
            @Override
            public boolean isValid(T object) {
                // Simple validation logic for demonstration
                return object != null;
            }
        };
    }
}

public class CatValidatorFactoryExample {
    public static void main(String[] args) {
        Cat cat = new Cat();
        AbstractValidator<Cat> validator = ValidatorFactory.getValidator(cat);
        System.out.println("Is cat valid? " + validator.isValid(cat));
    }
}