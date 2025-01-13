import java.lang.String;
import java.lang.Integer;
public class VulnerableExample {
    public static void main(String[] args) {
        int userProvidedValue = Integer.parseInt(args[0]); // assume user-provided input
        int[] array = new int[10];
        array[userProvidedValue] = 1; // potential buffer overflow
    }
}