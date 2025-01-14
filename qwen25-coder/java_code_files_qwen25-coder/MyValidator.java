// Necessary interfaces and classes
public interface Validator {
    boolean supports(Class<?> clazz);
    void validate(Object target, Errors errors);
}

public interface Errors {
    void rejectValue(String field, String errorCode, String defaultMessage);
}

public class MyCommand {
    public String getBudgetStr() {
        return "1000"; // Replace with appropriate value or logic
    }
}

// The MyValidator class
public class MyValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return MyCommand.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MyCommand myCommand = (MyCommand) target;
        String budgetStr = myCommand.getBudgetStr().replace(",", "");
        
        try {
            int budget = Integer.parseInt(budgetStr);
            // Proceed with validation...
        } catch (NumberFormatException e) {
            errors.rejectValue("budget", "number.format.error", "Invalid number format");
        }
    }

    public static void main(String[] args) {
        // Example usage
        MyValidator validator = new MyValidator();
        Errors errors = new Errors() {
            @Override
            public void rejectValue(String field, String errorCode, String defaultMessage) {
                System.out.println("Error in field '" + field + "': " + defaultMessage);
            }
        };

        MyCommand command = new MyCommand();
        validator.validate(command, errors);
    }
}