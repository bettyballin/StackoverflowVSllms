import java.lang.String;
public class PalindromeChecker {
    public static boolean isPalindrome(int num) {
        if (num < 0) {
            return false; // Negative numbers cannot be palindromes
        }

        int reversed = 0;
        int original = num;

        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }

        return original == reversed;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321)); // true
        System.out.println(isPalindrome(123456)); // false
    }
}