import java.lang.String;

public class SumCalculator {
    public int notTailRecursiveSum(int n) {
        if (n == 0) return 0;
        else return notTailRecursiveSum(n - 1) + n; // 'n' is added after returning from recursion
    }

    public static void main(String[] args) {
    }
}