import java.lang.String;
public class CustomStringHashCodeCalculator {
	public static void main(String[] args) {
		int length = "abcd".length();
		int hash = 0;
		for(int i = 0; i < length; i++) {
		    char c = "abcd".charAt(i); // 'a' -> 97, ...
		    hash += (int)(c * Math.pow(31, (length - 1) - i)); // Math.pow returns double; cast result to int
		}
		System.out.println("Hash code is : " + hash);
	}
}