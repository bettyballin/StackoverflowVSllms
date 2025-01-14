import java.lang.String;
public class ReverseWords {
    public static void main(String[] args) {
        char[] s = "My name is X Y Z".toCharArray();
        reverseWords(s);
        System.out.println(new String(s));
    }

    public static void reverseWords(char[] s) {
        // Step 1: Reverse the entire array
        reverse(s, 0, s.length - 1);

        // Step 2: Reverse each word in the reversed array
        int start = 0;
        for (int end = 0; end < s.length; end++) {
            if (s[end] == ' ') {
                reverse(s, start, end - 1);
                start = end + 1;
            }
        }
        // Reverse the last word
        reverse(s, start, s.length - 1);
    }

    private static void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}