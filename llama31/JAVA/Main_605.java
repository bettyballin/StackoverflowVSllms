import java.util.regex.Pattern;

public class Main_605_605 {
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        return pattern.matcher(str).matches();
    }

    public static void main(String[] args) {
        System.out.println(isNumeric("123")); // true
        System.out.println(isNumeric("123.45")); // true
        System.out.println(isNumeric("-123")); // true
        System.out.println(isNumeric("-123.45")); // true
        System.out.println(isNumeric("abc")); // false
    }
}