import java.lang.String;
public class Main_259 {
    public static void main(String[] args) {
        String str = "my string";
        String reversed = reverseWords(str);
        System.out.println(reversed); // prints "ym gnirts"
    }

    public static String reverseWords(String str) {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }
        return String.join(" ", words);
    }
}