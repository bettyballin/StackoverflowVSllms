import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_169 {
    public static void main(String[] args) {
        String html = "<i><b>test<i>ing</i>";
        Pattern pattern = Pattern.compile("<([^>]+)>(?!.*</\\1>)");
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            System.out.println("Unclosed tag: " + matcher.group(1));
        }
    }
}