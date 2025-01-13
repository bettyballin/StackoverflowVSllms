public class Sanitizer_8 {
    public static String sanitize(String input) {
        input = input.trim();
        input = input.replaceAll("<.*?>", "");
        input = input.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;");
        return input;
    }

    public static void main(String[] args) {
        System.out.println(sanitize("Hello, <b>World</b>!"));
    }
}