import java.lang.String;
public class Main_283 {
    public static void main(String[] args) {
        System.out.println(bitsRequired(11));  // prints 4
    }

    public static int bitsRequired(int n) {
        if (n == 0) return 1;
        int count = 0;
        while (n > 0) {
            n = n >> 1;
            count++;
        }
        return count;
    }
}