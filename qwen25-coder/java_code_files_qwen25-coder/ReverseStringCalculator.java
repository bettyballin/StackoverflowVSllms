import java.lang.String;
public class ReverseStringCalculator {
    // Example: Fault in a simple program that reverses a string
    public String reverseString(String input) {
        StringBuilder reversed = new StringBuilder();
        for (int i = 0; i < input.length(); i++) { // Fault: should be 'i--' if decrementing from length
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }
    public static void main(String[] args) {
    }
}