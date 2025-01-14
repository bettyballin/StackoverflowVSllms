import java.lang.String;
public class IntegerHasher {
    public static int hash(int key) {
        // Using a large prime number for multiplication
        final int LARGE_PRIME = 0x9e3779b1;
        return key * LARGE_PRIME ^ (key >>> 16);
    }

	public static void main(String[] args) {
	}
}