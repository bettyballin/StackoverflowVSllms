import com.jgoodies.validation.Severity;
import com.jgoodies.validation.Validator;
import com.jgoodies.validation.ValidationResult;
import com.jgoodies.validation.ValidationUtils;
import com.jgoodies.validation.rule.StringNotBlankRule;
import com.jgoodies.validation.rule.StringLengthRule;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Main_542 {
    public static void main(String[] args) {
        // Create a validator
        Validator validator = new Validator();

        // Add a validation rule for a JTextField
        validator.addValidationRule("username", "must not be empty", Severity.ERROR,
                new StringNotBlankRule());

        // Add a validation rule for a JPasswordField
        validator.addValidationRule("password", "must be at least 6 characters", Severity.WARNING,
                new StringLengthRule(6, Integer.MAX_VALUE));

        // Create a ValidationUtils to connect the validator to the Swing components
        ValidationUtils utils = new ValidationUtils(validator);

        // Create a JTextField and a JPasswordField
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        // Connect the validator to the components
        utils.addComponent(usernameField, "username");
        utils.addComponent(passwordField, "password");

        // Validate the form
        ValidationResult result = validator.validate();

        // Check the result
        if (result.hasErrors()) {
            // Handle errors
            System.out.println("Form has errors");
        } else {
            // Form is valid
            System.out.println("Form is valid");
        }
    }
}