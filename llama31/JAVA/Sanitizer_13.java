public class Sanitizer_13 {
    public static String sanitize(String input) {
        return input.trim().replaceAll("<.*?>", "");
    }

    public static void main(String[] args) {
        String input = "<p>Hello, World!</p>";
        System.out.println(sanitize(input));
    }
}