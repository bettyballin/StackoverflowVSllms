import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IfElseSplitter {
    public static void main(String[] args) {
        String input = "<if>abc <else>xyz";
        Pattern pattern = Pattern.compile("<if>(.*?)<else>(.*?)$");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            String ifPart = matcher.group(1).trim();
            String elsePart = matcher.group(2).trim();
            System.out.println("If part: " + ifPart);
            System.out.println("Else part: " + elsePart);
        } else {
            System.out.println("Input string does not match the expected format.");
        }
    }
}