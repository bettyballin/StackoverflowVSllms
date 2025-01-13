import java.lang.Integer;
import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThumbReplacer {
    public static String replaceThumbs(String articleText, String[] photos) {
        Pattern pattern = Pattern.compile("\\[thumb(\\d+)\\]");
        Matcher matcher = pattern.matcher(articleText);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            String replacement = "<img src=\"thumbs/" + photos[Integer.parseInt(matcher.group(1))] + "\">";
            matcher.appendReplacement(buffer, replacement);
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

	public static void main(String[] args) {
	}
}