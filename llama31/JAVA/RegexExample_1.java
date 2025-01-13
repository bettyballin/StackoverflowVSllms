import java.lang.String;
import java.util.regex.Pattern;

public class RegexExample_1 {
    public static void main(String[] args) {
        String input = "<select>hello</select><script>alert('XSS')</script>";
        String regex = "<(?!select|\\/select).*?>";
        String cleanInput = input.replaceAll(regex, "");
        System.out.println(cleanInput); // Output: <select>hello</select>
    }
}