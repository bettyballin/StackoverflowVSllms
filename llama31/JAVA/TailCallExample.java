import java.lang.String;
public class TailCallExample {
    public static void main(String[] args) {
        System.out.println(factorial(10));
    }

    public static int factorial(int n) {
        return factorial(n, 1);
    }

    public static int factorial(int n, int acc) {
        if (n == 0) {
            return acc;
        } else {
            return factorial(n - 1, n * acc);
        }
    }
}