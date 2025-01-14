import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_120 {
    public static void main(String[] args) {
        String input = "<a><strike>example data in here</strike></a>";
        Pattern pattern = Pattern.compile("<a>(.*?)</a>");
        Matcher matcher = pattern.matcher(input);
        
        if (matcher.find()) {
            System.out.println("Content inside <a>: " + matcher.group(1));
        } else {
            System.out.println("No match found.");
        }
    }
}