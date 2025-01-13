import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_266 {
    public static void main(String[] args) {
        String input = "=?iso-8859-1?Q?H=E4 ll?= preserve this text =?iso-8859-1?Q?mo nk ey?=";
        String output = removeWhitespaceWithinBoundaries(input);
        System.out.println(output);
    }

    public static String removeWhitespaceWithinBoundaries(String input) {
        Pattern pattern = Pattern.compile("=(\\?[^?]+\\?)");
        Matcher matcher = pattern.matcher(input);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            matcher.appendReplacement(buffer, group.replaceAll("\\s+", ""));
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }
}