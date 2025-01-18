import java.lang.String;
public class Key {
    private final String key;

    public Key(String key) {
        this.key = key;
    }

    @Override
    public int hashCode() { // Implement own calculation for improved unique hash value generation
        return (int)(Math.pow(31, 2 * (this.key.length()) % 97)) ;
     }

	public static void main(String[] args) {
	}
}