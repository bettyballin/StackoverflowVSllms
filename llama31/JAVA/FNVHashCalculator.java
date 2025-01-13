import java.lang.String;

public class FNVHashCalculator {
    public static void main(String[] args) {
        String input = "example";
        int hash = FNVHash.hash(input);
        System.out.println(hash);
    }
}

class FNVHash {
    public static int hash(String input) {
        final int prime = 16777219;
        int hash = 2166136261;
        for (int i = 0; i < input.length(); i++) {
            hash = (hash ^ input.charAt(i)) * prime;
        }
        return hash;
    }
}