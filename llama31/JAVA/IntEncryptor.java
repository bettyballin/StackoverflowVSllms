import java.lang.String;
public class IntEncryptor {
    private int secretKey;

    public IntEncryptor(int secretKey) {
        this.secretKey = secretKey;
    }

    public int encrypt(int input) {
        return input ^ secretKey;
    }

    public int decrypt(int encrypted) {
        return encrypted ^ secretKey;
    }

	public static void main(String[] args) {
	}
}