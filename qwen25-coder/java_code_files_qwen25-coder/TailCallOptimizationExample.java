import java.lang.String;
public class TailCallOptimizationExample {
    // Without TCO
    public static int recursiveFunction(int n, int accumulator) {
        if (n == 0) return accumulator;
        else return recursiveFunction(n - 1, accumulator + n);
    }

    // With TCO (hypothetical), the compiler might optimize this to a loop internally
    public static int tailCallOptimizedFunction(int n, int accumulator) {
        while (true) {
            if (n == 0) return accumulator;
            else {
                n = n - 1;
                accumulator = accumulator + n;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(recursiveFunction(5, 0));
        System.out.println(tailCallOptimizedFunction(5, 0));
    }
}