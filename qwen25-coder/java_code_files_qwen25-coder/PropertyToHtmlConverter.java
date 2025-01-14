import java.lang.String;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyToHtmlConverter {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("path/to/config.properties");
        props.load(fis);

        StringBuilder htmlContent = new StringBuilder("<html><body>");
        for (String key : props.stringPropertyNames()) {
            String value = props.getProperty(key);
            if (value.equalsIgnoreCase("Y") || value.equalsIgnoreCase("N")) {
                // Radio buttons
                htmlContent.append(generateRadioButtons(key, value));
            } else if (key.endsWith(".path")) {
                // Read-only field (example rule)
                htmlContent.append(generateReadOnlyField(key, value));
            } else if (value.contains(",")) { // Assuming values like "option1,option2"
                // Dropdown
                htmlContent.append(generateDropdown(key, value.split(",")));
            } else {
                // Text input by default
                htmlContent.append(generateTextInput(key, value));
            }
        }
        htmlContent.append("</body></html>");

        System.out.println(htmlContent.toString());
    }

    private static String generateRadioButtons(String key, String selectedValue) {
        return "<label>" + key + ": </label>" +
               "<input type='radio' name='" + key + "' value='Y'" + (selectedValue.equalsIgnoreCase("Y") ? " checked" : "") + "> Yes " +
               "<input type='radio' name='" + key + "' value='N'" + (selectedValue.equalsIgnoreCase("N") ? " checked" : "") + "> No <br>";
    }

    private static String generateReadOnlyField(String key, String value) {
        return "<label>" + key + ": </label><input type='text' name='" + key + "' value='" + value + "' readonly><br>";
    }

    private static String generateDropdown(String key, String[] options) {
        StringBuilder dropdown = new StringBuilder("<label>" + key + ": </label><select name='" + key + "'>");
        for (String option : options) {
            dropdown.append("<option>").append(option).append("</option>");
        }
        dropdown.append("</select><br>");
        return dropdown.toString();
    }

    private static String generateTextInput(String key, String value) {
        return "<label>" + key + ": </label><input type='text' name='" + key + "' value='" + value + "'><br>";
    }
}