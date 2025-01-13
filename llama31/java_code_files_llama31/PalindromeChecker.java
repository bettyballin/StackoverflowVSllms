/*
 * Decompiled with CFR 0.152.
 */
public class PalindromeChecker {
    public static boolean isPalindrome(int n) {
        if (n < 0) {
            return false;
        }
        int n2 = 0;
        int n3 = n;
        while (n != 0) {
            int n4 = n % 10;
            n2 = n2 * 10 + n4;
            n /= 10;
        }
        return n3 == n2;
    }

    public static void main(String[] stringArray) {
        System.out.println(PalindromeChecker.isPalindrome(12321));
        System.out.println(PalindromeChecker.isPalindrome(123456));
    }
}
