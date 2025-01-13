import java.lang.String;

public class StringHashCalculator_1_1 {
    public static int hashCode(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = 31 * hash + s.charAt(i);
        }
        return hash;
    }

    public static void main(String[] args) {
    }
}