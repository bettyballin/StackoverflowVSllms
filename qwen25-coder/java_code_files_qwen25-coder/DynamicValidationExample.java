import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.metadata.BeanDescriptor;
import javax.validation.metadata.PropertyDescriptor;
import javax.validation.metadata.ConstraintDescriptor;
import javax.validation.ConstraintViolation;
import java.util.Set;

public class DynamicValidationExample {

    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        MyPojo myPojo = new MyPojo();
        myPojo.setMyField("user@example.com");

        // Create a descriptor for the bean
        BeanDescriptor beanDescriptor = validator.getConstraintsForClass(MyPojo.class);
        PropertyDescriptor propertyDescriptor = beanDescriptor.getConstraintsForProperty("myField");

        // Clear any existing constraints (simplified for example, in practice remove specific constraints)
        Set<ConstraintViolation<MyPojo>> violations;

        if (useEmailValidation()) {
            // Check if Email constraint is already present
            boolean hasEmailConstraint = false;
            Set<ConstraintDescriptor<?>> constraintDescriptors = propertyDescriptor.getConstraintDescriptors();
            for (ConstraintDescriptor<?> descriptor : constraintDescriptors) {
                if (descriptor.getAnnotation().annotationType().equals(Email.class)) {
                    hasEmailConstraint = true;
                    break;
                }
            }
            if (!hasEmailConstraint) {
                // Simulate adding the email validation programmatically
                // In practice, you would need to use a ConstraintValidatorFactory and ConstraintValidatorContext
                // This is just a placeholder for demonstration
            }
        }

        violations = validator.validate(myPojo);

        for (ConstraintViolation<MyPojo> violation : violations) {
            System.out.println(violation.getMessage());
        }
    }

    private static boolean useEmailValidation() {
        return true; // This would be replaced with your runtime logic to determine validation rules
    }

}

class MyPojo {
    private String myField;

    public void setMyField(String myField) {
        this.myField = myField;
    }

    @NotEmpty // Initially empty, dynamic change at runtime is simulated
    public String getMyField() {
        return myField;
    }
}