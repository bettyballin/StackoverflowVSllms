import java.util.regex.*;

public class Validator {
    public boolean validateInput(String firstName, String lastName, String email) {
        Pattern namePattern = Pattern.compile("^[A-Za-z]+$");
        Matcher nameMatcherFirstName = namePattern.matcher(firstName);
        Matcher nameMatcherLastName = namePattern.matcher(lastName);

        Pattern emailPattern = Pattern.compile("^\\S+@\\S+\\.\\S+$");
        Matcher emailMatcher = emailPattern.matcher(email);

        return (nameMatcherFirstName.matches() && nameMatcherLastName.matches() && emailMatcher.matches());
    }
}