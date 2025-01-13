import java.lang.String;
public class CustomHash {
    public static int hashCode(String input) {
        int hash = 0;
        for (char c : input.toCharArray()) {
            hash = (hash * 37 + c) ^ (hash >>> 16);
        }
        return hash;
    }

	public static void main(String[] args) {
	}
}