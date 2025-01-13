import org.apache.commons.text.StringEscapeUtils;

public class Main_716 {
    public static void main(String[] args) {
        // Example input from user
        String userInput = "Example User Input";

        // Escape SQL special characters
        String escapedInput = StringEscapeUtils.escapeSql(userInput);
        
        // Use the escaped input in your SQL query
        System.out.println("Escaped Input: " + escapedInput);
    }
}