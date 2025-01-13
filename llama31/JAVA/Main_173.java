import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_173 {
    public static void main(String[] args) {
        String input = "<if>abc <else>xyz";
        Pattern pattern = Pattern.compile("<if>(.*?)<else>(.*)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            String ifString = matcher.group(1).trim();
            String elseString = matcher.group(2).trim();

            System.out.println("If: " + ifString);
            System.out.println("Else: " + elseString);
        }
    }
}