import java.util.Scanner;

public class Main_395_395 {
    public static void main(String[] args) {
        int xor = 0;
        for (int i = 1; i < (1 << 32); i++) {
            xor ^= i;
        }

        Scanner scanner = new Scanner(System.in);
        int n = 1 << 32 - 2; // number of input integers
        for (int i = 0; i < n; i++) {
            xor ^= scanner.nextInt();
        }

        System.out.println(xor);
        scanner.close();
    }
}