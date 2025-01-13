import java.lang.String;
import java.util.Scanner; // added import statement for Scanner

public class Main_396_396 {
    public static void main(String[] args) {
        int xor = 0;
        for (int i = 0; i < (1 << 16); i++) {
            xor ^= i;
        }

        Scanner scanner = new Scanner(System.in);
        int n = 1 << 32 - 2; // number of input integers
        for (int i = 0; i < n; i++) {
            int next = scanner.nextInt();
            xor ^= (next >> 16) ^ (next & ((1 << 16) - 1));
        }

        for (int i = 0; i < (1 << 16); i++) {
            xor ^= (i << 16) ^ i;
        }

        System.out.println(xor);
        scanner.close(); // added to close the scanner to prevent resource leak
    }
}