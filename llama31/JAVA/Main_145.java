import java.lang.String;
public class Main_145 {
    public static void main(String[] args) {
        String s1 = "My name is X Y Z";
        System.out.println(reverseWords(s1));
    }

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }
        reverse(chars, start, chars.length - 1);
        return new String(chars);
    }

    public static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}