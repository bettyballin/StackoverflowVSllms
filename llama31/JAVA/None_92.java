import java.util.regex.Pattern;

public class None_92_92 {
    public static String filterVar(String input) {
        return Pattern.compile("[^\\x09\\x0A\\x0D\\x20-\\uD7FF\\uE000-\\uFFFD\\u10000-\\u10FFFF]").matcher(input).replaceAll("");
    }

    public static void main(String[] args) {
    }
}