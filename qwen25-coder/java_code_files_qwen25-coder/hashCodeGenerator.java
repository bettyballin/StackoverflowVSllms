import java.lang.String;
public class hashCodeGenerator {
    public int hashCode(char[] value, int length) {
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash = 31 * hash + value[i];
        }
        return hash;
    }
    public static void main(String[] args) {
    }
}