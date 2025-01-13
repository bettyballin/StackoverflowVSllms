import java.lang.String;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        String regex = "^(?=.*[a-zA-Z].*[a-zA-Z])(?=.*\\d.*\\d)[a-zA-Z0-9]{6}$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println(pattern.matcher("xx12ab").matches()); // true
        System.out.println(pattern.matcher("x12345").matches()); // false
        System.out.println(pattern.matcher("xxxxx1").matches()); // false
        System.out.println(pattern.matcher("xxx123").matches()); // true
    }
}