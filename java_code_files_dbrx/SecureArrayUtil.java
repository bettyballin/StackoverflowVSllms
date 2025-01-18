import java.lang.String;
public class SecureArrayUtil {
    public static void wipeArray(char[] secureArray) {
        for (int i = 0; i < secureArray.length; ++i) {
            secureArray[i] = 0;
        }
    }
    
    public static void main(String[] args) {
    }
}