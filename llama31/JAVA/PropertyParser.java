import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyParser {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.load(new FileReader(new File("path/to/your/properties/file.properties")));

        StringBuilder html = new StringBuilder("<html><body>");

        for (String key : props.stringPropertyNames()) {
            String value = props.getProperty(key);

            // Determine the input type based on the property value
            if (value.equalsIgnoreCase("Y") || value.equalsIgnoreCase("N")) {
                // Radio button
                html.append("<p>").append(key).append("</p>");
                html.append("<input type='radio' name='").append(key).append("' value='Y'>Yes");
                html.append("<input type='radio' name='").append(key).append("' value='N'>No");
            } else if (value.contains(",")) {
                // List box
                html.append("<p>").append(key).append("</p>");
                html.append("<select name='").append(key).append("'>");
                String[] options = value.split(",");
                for (String option : options) {
                    html.append("<option value='").append(option.trim()).append("'>").append(option.trim()).append("</option>");
                }
                html.append("</select>");
            } else if (key.contains("path")) {
                // Read-only input field
                html.append("<p>").append(key).append("</p>");
                html.append("<input type='text' name='").append(key).append("' value='").append(value).append("' readonly>");
            } else {
                // Text input field
                html.append("<p>").append(key).append("</p>");
                html.append("<input type='text' name='").append(key).append("' value='").append(value).append("'>");
            }
        }

        html.append("</body></html>");

        System.out.println(html.toString());
    }
}