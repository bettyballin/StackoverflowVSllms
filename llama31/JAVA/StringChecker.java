import java.lang.String;

public class StringChecker {
    public static void main(String[] args) {
        Object obj = "Hello";
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println(str);
        } else {
            System.out.println("obj is not a String");
        }
    }
}