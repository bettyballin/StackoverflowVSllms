public class TextSanitizer {
    public static void main(String[] args) {
        String input = "i like cats\n\n\nmy cat is happy\ni love my cat\n\n\n\nhope you have a nice day\n";
        String sanitized = input.replaceAll("\n{2,}", "\n\n");
        System.out.println(sanitized);
    }
}