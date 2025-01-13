import java.lang.String;

public class UrlLinkifier {
    public static void main(String[] args) {
        String input = "Hello, visit https://example.com or www.example.com for more info.";
        String output = input.replaceAll("(?<!<img[^>]*)(https?://[^\\s]+|www\\.[^\\s]+)(?!.*</img>)", "<a href=\"$1\">$1</a>");
        System.out.println(output);
    }
}