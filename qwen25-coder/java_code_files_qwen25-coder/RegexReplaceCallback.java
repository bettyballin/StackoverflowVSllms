import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplaceCallback {
    public static void main(String[] args) {
        String articleText = "[thumb1] is the first thumbnail [thumb2] is the second.";
        Map<String, String> photos = new HashMap<>();
        photos.put("1", "photo1.jpg");
        photos.put("2", "photo2.jpg");

        // Define the pattern
        Pattern pattern = Pattern.compile("\\[thumb(\\d+)\\]");
        Matcher matcher = pattern.matcher(articleText);

        // Use a StringBuffer to build the result string
        StringBuffer sb = new StringBuffer();

        // Iterate over all matches and apply the replacement logic
        while (matcher.find()) {
            String number = matcher.group(1);
            String thumbUrl = "<img src=\"thumbs/" + photos.get(number) + "\">";
            matcher.appendReplacement(sb, "");
            sb.append(thumbUrl);
        }
        matcher.appendTail(sb);

        // Output the modified string
        System.out.println(sb.toString());
    }
}