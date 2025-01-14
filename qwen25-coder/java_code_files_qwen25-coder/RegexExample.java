import java.lang.String;
import java.util.regex.*;
import java.util.*;

public class RegexExample {
    public static void main(String[] args) {
        String input1 = "$10/$50";
        String input2 = "50c/70c";

        Pattern pattern = Pattern.compile("([\\d]+)$|([\\d]+)c$");
        Matcher matcher1 = pattern.matcher(input1);
        Matcher matcher2 = pattern.matcher(input2);

        if (matcher1.find()) {
            String match = matcher1.group(1); // Matches "50" in "$10/$50"
            System.out.println("Dollars: " + match);
        }

        if (matcher2.find()) {
            String centsMatch = matcher2.group(1); // Matches "70" in "50c/70c"
            double convertedValue = Double.parseDouble(centsMatch) / 100;
            System.out.println("Cents: " + convertedValue);
        }
    }
}