import java.lang.String;

public class FNVHash {
    private static final int FNV_OFFSET_BASIS = 2166136261;
    private static final int FNV_PRIME = 16777219;

    public static int hash(String str) {
        int hash = FNV_OFFSET_BASIS;
        for (char c : str.toCharArray()) {
            hash ^= c;
            hash *= FNV_PRIME;
        }
        return hash;
    }

	public static void main(String[] args) {
        System.out.println(hash("Hello, World!"));
	}
}