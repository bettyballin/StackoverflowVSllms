import java.lang.String;
public class BigOAnalyzer {
    // Example: O(n^2 + n) vs O(10n^2)
    public int inefficient(int[] array) {
        int sum = 0;
        for (int i : array) sum += i * i; // n^2 term
        for (int i : array) sum += i;     // n term
        return sum;
    }

    public int efficient(int[] array) {
        int sum = 0;
        for (int i : array) sum += 10 * i * i; // 10n^2 term
        return sum;
    }

    public static void main(String[] args) {
    }
}