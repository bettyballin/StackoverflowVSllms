import java.lang.String;
import java.util.regex.*;

public class FilterUserInput {
    public static void main(String[] args) {
         String input = "ユーザー名!@#$%^&*()"; // Your user input, e.g., a Japanese username with special characters
        Pattern pattern = Pattern.compile("\\P{IsAlphabetic}"); // Matches non-alphabetical unicode characters as per the \p and \P rules - https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
        Matcher matcher = pattern.matcher(input);

        String filteredInput = matcher.replaceAll(""); // Replaces all non-alphabetical characters with an empty string, thus filtering them out

        System.out.println("Filtered input: " + filteredInput);
    }
}