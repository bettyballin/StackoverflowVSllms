import java.lang.String;

public class StringHasher_1_1 {
    public int hash(String s) {
        int hash = 0;
        int multiplier = 31; // a large prime number
        for (char c : s.toCharArray()) {
            hash = hash * multiplier + c;
        }
        return hash;
    }

    public static void main(String[] args) {
        StringHasher_1 hasher = new StringHasher_1();
        System.out.println(hasher.hash("Hello, World!"));
    }
}