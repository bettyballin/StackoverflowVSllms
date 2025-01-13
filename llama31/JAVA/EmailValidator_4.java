import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Email;

public class EmailValidator_4_4 {
    @Email
    private String email;

    public static boolean isValidEmail(String email) {
        try {
            EmailValidator_4 validator = new EmailValidator_4();
            validator.email = email;
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validatorBean = factory.getValidator();
            validatorBean.validate(validator);
            return true;
        } catch (ConstraintViolationException e) {
            return false;
        }
    }

    public static void main(String[] args) {
    }
}