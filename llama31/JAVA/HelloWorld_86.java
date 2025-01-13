import java.lang.String;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HelloWorld_86 {

    public static void main(String[] args) {
        String stringToSearch = "<p>How to retrieve the text between two html markup with c# ?</p>";
        String patternString = "<p>(.*?)</p>";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(stringToSearch);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}