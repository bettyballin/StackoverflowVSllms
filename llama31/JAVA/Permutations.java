import java.lang.String;
public class Permutations {
    public static void permute(String str) {
        // Base case: if string length is 1, print it
        if (str.length() == 1) {
            System.out.println(str);
        } else {
            // Recursive case: swap each character with the rest of the string
            for (int i = 0; i < str.length(); i++) {
                String remainingStr = str.substring(0, i) + str.substring(i + 1);
                permute(remainingStr + str.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println("Permutations of " + str + ":");
        permute(str);
    }
}