import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CurrencyConverter {
    public static void main(String[] args) {
        String input = "50c/70c";
        Pattern pattern = Pattern.compile("([\\d]*)(?:c)?$|([\\d]*)$");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String value = matcher.group(1) != null ? matcher.group(1) : matcher.group(2);
            if (input.endsWith("c")) {
                // convert cents to dollars
                double dollars = Double.parseDouble(value) / 100;
                System.out.println(dollars);
            } else {
                System.out.println(value);
            }
        }
    }
}