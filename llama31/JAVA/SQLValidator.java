import java.lang.String;
import org.owasp.esapi.codecs.UnixCodec;
import org.owasp.esapi.errors.ValidationException;
import org.owasp.esapi.validator.Validator;

public class SQLValidator {
    private final Validator validator;

    public SQLValidator(Validator validator) {
        this.validator = validator;
    }

    public void validateSQL(String sql) throws ValidationException {
        String[] keywords = {"=", "in"};
        for (String keyword : keywords) {
            int index = sql.toLowerCase().indexOf(keyword);
            if (index != -1) {
                String[] parts = sql.substring(index + keyword.length()).split("\\s+");
                if (parts.length > 0 && !parts[0].startsWith("?")) {
                    throw new ValidationException("Non-parameterized SQL detected: " + sql);
                }
            }
        }
    }

    public static void main(String[] args) {
        // To test or use this class, you would need to instantiate it with a Validator
        // and call the validateSQL method with a String argument.
        // Example:
        // Validator validator = new Validator(); // Assuming a default Validator implementation
        // SQLValidator sqlValidator = new SQLValidator(validator);
        // try {
        //     sqlValidator.validateSQL("SELECT * FROM users WHERE id = ?");
        // } catch (ValidationException e) {
        //     System.out.println(e.getMessage());
        // }
    }
}