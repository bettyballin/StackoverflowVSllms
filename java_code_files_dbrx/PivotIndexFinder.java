import java.util.Arrays;

public class PivotIndexFinder {
    public int solve(int[] numbers) {
        int leftSum = 0;
        int rightSum = Arrays.stream(numbers).sum();

        for (int i = 0, size = numbers.length; i < size && leftSum <= rightSum; ++i) {
            if ((rightSum -= numbers[i]) == leftSum) {
                return i;
            } else {
                leftSum += numbers[i];
            }
        }
        // no solution, return -1
        return -1;
    }

    public static void main(String[] args) {
    }
}