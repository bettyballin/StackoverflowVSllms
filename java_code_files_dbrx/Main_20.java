import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        String input = "$10/$50"; // or any other valid input, ex.: "50c/70c"
        Pattern pattern = Pattern.compile("([\\d]*$)|(^[\\d]+)c$");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) { // if a match is found
            String matchedString = matcher.group(); 
            try { // since we're dealing with cents, let's format it to dollars first
                double valueInDollars;
                if (!matchedString.contains("c")) {
                    valueInDollars = Double.parseDouble(matchedString);
                } else {
                    String cents = matchedString.substring(0, matchedString.indexOf('c')); // getting rid of 'c' symbol
                    double centValueAsDouble = Double.parseDouble(cents);
                    valueInDollars = centValueAsDouble / 100; // converting to dollars by dividing by hundred since it's in cents
                }    
                System.out.println("Formatted number: " + String.format("%6f", (Object)valueInDollars));   // print the formatted result, precision up to 5 decimal places
            } catch (Exception e) {
                throw new RuntimeException(e); // do something smart here :)
            }
        } else {
            System.out.println("No match found");
        }
    }
}