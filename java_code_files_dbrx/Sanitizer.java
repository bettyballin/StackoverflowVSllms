import java.lang.String;
public class Sanitizer {
    String searchBoxInput = "";
    String input = searchBoxInput.replaceAll("'", "\\'"); // The double slash is necessary to pass the \ in Java strings
    public static void main(String[] args) {
    }
}