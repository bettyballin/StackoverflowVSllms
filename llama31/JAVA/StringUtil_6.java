import java.lang.String;
public class StringUtil_6 {
    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);
    }

    public static void main(String[] args) {
        System.out.println(padRight("Hello", 10)); // prints "Hello     "
        System.out.println(padLeft("Hello", 10));  // prints "     Hello"
    }
}