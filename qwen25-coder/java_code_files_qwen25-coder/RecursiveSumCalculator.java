import java.lang.String;
public class RecursiveSumCalculator {
    public int sum(int n, int accumulator) {
        if (n == 0) return accumulator;
        else return sum(n - 1, accumulator + n);
    }
    public static void main(String[] args) {
    }
}