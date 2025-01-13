import java.lang.String;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.HashMap;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorFactory;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ValidatorContext;
import javax.validation.constraints.Email;
import javax.validation.constraints.CreditCardNumber;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Create a custom ConstraintValidatorFactory
public class DynamicValidatorFactory implements ConstraintValidatorFactory {
    private Map<String, ConstraintValidator<?, ?>> validators = new HashMap<>();

    public void addValidator(String fieldName, ConstraintValidator<?, ?> validator) {
        validators.put(fieldName, validator);
    }

    @Override
    public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> key) {
        // Return the validator instance based on the runtime configuration
        return (T) validators.get(key.getName());
    }
}

// Create a custom validator that can be configured at runtime
public class DynamicValidator implements ConstraintValidator<DynamicConstraint, String> {
    private ConstraintValidator<?, ?> delegate;

    public DynamicValidator(ConstraintValidator<?, ?> delegate) {
        this.delegate = delegate;
    }

    @Override
    public void initialize(DynamicConstraint constraintAnnotation) {
        // No-op
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return delegate.isValid(value, context);
    }
}

// Define a custom annotation for the dynamic validation
@Constraint(validatedBy = DynamicValidator.class)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface DynamicConstraint {
    String fieldName();
}

// Use the custom annotation on your POJO
class MyPojo {
    @DynamicConstraint(fieldName = "myField")
    public String getMyField() {
        return "";
    }
}

// Create custom validator for email
class EmailValidator implements ConstraintValidator<Email, String> {
    @Override
    public void initialize(Email constraintAnnotation) {
        // No-op
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Basic email validation
        return value.contains("@");
    }
}

public class Main {
    public static void main(String[] args) {
        // Configure the validation rules at runtime
        DynamicValidatorFactory factory = new DynamicValidatorFactory();
        factory.addValidator("myField", new EmailValidator()); // or new CreditCardNumberValidator()

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        ValidatorContext context = validatorFactory.usingContext();
        context.constraintValidatorFactory(factory);
        Validator validator = context.getValidator();

        MyPojo pojo = new MyPojo();
        System.out.println(validator.validate(pojo));
    }
}