import java.lang.String;
public class PalindromeChecker {

    // Recursive method to check if a string is a palindrome
    public static boolean isPalindromeRecursive(String s) {
        return isPalindromeHelper(s, 0, s.length() - 1);
    }

    private static boolean isPalindromeHelper(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return isPalindromeHelper(s, left + 1, right - 1);
    }

    // Iterative method to check if a string is a palindrome
    public static boolean isPalindromeIterative(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String testString = "radar";
        System.out.println("Recursive: " + isPalindromeRecursive(testString));
        System.out.println("Iterative: " + isPalindromeIterative(testString));
    }
}