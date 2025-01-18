import java.lang.String;
import java.lang.Integer;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DecimalExtractor {
    static {
        String text = "<span class='Txt9Gray'>Decisions ( </span> \n"
            + "</code>\n"
            + "1 <span class='Txt9Gray'> Decision ( 33.33 <br />";
        Pattern pattern = Pattern.compile("(?:Decimal\\s*\\(\\s*?)([\\d]+)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(Integer.parseInt(matcher.group())); // this will print '1' in console output.
        }
    }

    public static void main(String[] args) {
    }
}