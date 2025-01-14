public abstract class AbstractValidator<T> {
    public abstract void validate(T obj);
}

class CustomerValidator extends AbstractValidator<Customer> {
    @Override
    public void validate(Customer customer) {
        // Validation logic for Customer
    }
}

class CatValidator extends AbstractValidator<Cat> {
    @Override
    public void validate(Cat cat) {
        // Validation logic for Cat
    }
}

class Customer {
    private String name;
    // Getters and setters...
}

class Cat {
    private String name;
    // Getters and setters...
}

public class ValidatorFactory {

    // Method to dynamically get validator based on the object's class type
    public static <T> AbstractValidator<T> getValidator(T obj) throws ReflectiveOperationException {
        String className = obj.getClass().getSimpleName() + "Validator";
        Class<?> clazz = Class.forName(className);
        return (AbstractValidator<T>) clazz.getDeclaredConstructor().newInstance();
    }

    public static void main(String[] args) {
        try {
            Cat cat = new Cat();
            AbstractValidator<Cat> catValidator = getValidator(cat);
            // Use the catValidator to validate a Cat object

            Customer customer = new Customer();
            AbstractValidator<Customer> customerValidator = getValidator(customer);
            // Use the customerValidator to validate a Customer object
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}