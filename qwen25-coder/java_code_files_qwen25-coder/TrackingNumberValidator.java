import java.lang.String;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrackingNumberValidator {
    public static void main(String[] args) {
        String upsPattern = "1Z[0-9A-Z]{3}[0-9A-Z*][0-9A-Z]{16}[0-9A-Z]";
        String fedExPattern = "(\\d{12}|\\d{15})";
        String dhlPattern = "[A-Za-z]\\d{9}[A-Za-z]?";
        String airBornePattern = "\\d{11}";
        
        Pattern[] patterns = {Pattern.compile(upsPattern), Pattern.compile(fedExPattern),
                              Pattern.compile(dhlPattern), Pattern.compile(airBornePattern)};
        
        String[] testNumbers = {"1Z5W1A1AA100036237", "9261290100004455230088032", 
                               "Y4185495688GB", "2038417455"};
        
        for (Pattern pattern : patterns) {
            for (String number : testNumbers) {
                Matcher matcher = pattern.matcher(number);
                if (matcher.matches()) {
                    System.out.println(number + " matches the pattern: " + pattern.pattern());
                }
            }
        }
    }
}