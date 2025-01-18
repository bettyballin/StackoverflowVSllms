import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTagStripper {
    public static void main(String[] args) {
        String pattern = "(?i)(?!<\\s*select\\b)[<>]";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher("<div>Some text <select></select></div>");
        String result = matcher.replaceAll("");
        System.out.println(result);
    }
}