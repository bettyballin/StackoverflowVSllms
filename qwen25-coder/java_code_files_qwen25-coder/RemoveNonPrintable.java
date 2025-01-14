import java.lang.String;
public class RemoveNonPrintable {
    public static String cleanString(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            // Check if the character is a printable ASCII character
            if ((c >= 32 && c <= 126)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String original = "Hello, World!\0This is a test.\127";
        String cleaned = cleanString(original);
        System.out.println("Original: " + original);
        System.out.println("Cleaned: " + cleaned);
    }
}