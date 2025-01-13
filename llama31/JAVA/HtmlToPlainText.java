import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlToPlainText {
    public static String htmlToPlainText(String html) {
        String regex = "<.*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);
        return matcher.replaceAll("");
    }

    public static void main(String[] args) {
        String html = "<p>This is a paragraph with <b>bold</b> text.</p>";
        System.out.println(htmlToPlainText(html));
    }
}