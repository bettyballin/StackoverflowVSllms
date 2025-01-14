import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class FormValidator {

    private static final List<String> EXPECTED_VALUES = Arrays.asList("Option1", "Option2", "Option3");

    public static boolean isValidSelection(String submittedValue) {
        return EXPECTED_VALUES.contains(submittedValue);
    }

    public void processFormSubmission(Map<String, String[]> formData) {
        String selection = formData.getOrDefault("dropdownField", new String[] {""})[0];
        
        if (!isValidSelection(selection)) {
            throw new IllegalArgumentException("Invalid selection: " + selection);
        }
        
        // Proceed with processing the rest of the form data
    }

    public static void main(String[] args) {
    }
}