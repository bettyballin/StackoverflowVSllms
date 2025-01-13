import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTrimmer {
    public static String trimHtml(String html) {
        String regex = ">\\s+<|>\\s+|\\s+<";
        String replacement = "><";
        return html.replaceAll(regex, replacement);
    }

    public static void main(String[] args) {
        String html = "<html>\n" +
                "   <head>\n" +
                "     <title>\n" +
                "           Some title\n" +
                "       </title>\n" +
                "    </head>\n" +
                "</html>";
        System.out.println(trimHtml(html)); // <html><head><title>Some title</title></head></html>
    }
}