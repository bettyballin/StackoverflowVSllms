import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTagSplitter {
    public static void main(String[] args) {
        String input = "<b>Bold</b> This is the stuff <i>Italic</i>";
        Pattern pattern = Pattern.compile("(<[^>]*>|[^<>]+)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}