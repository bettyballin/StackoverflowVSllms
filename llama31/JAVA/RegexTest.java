import java.lang.String;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTest {
    public static void main(String[] args) {
        String[] input = {
            "785*()&!~`a",
            "##$%$~2343",
            "455frt&*&*"
        };

        Pattern pattern = Pattern.compile(".*[a-zA-Z].*");

        for (String s : input) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.matches()) {
                System.out.println("Match: " + s);
            }
        }
    }
}