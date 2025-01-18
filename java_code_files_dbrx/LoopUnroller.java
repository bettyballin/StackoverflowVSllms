import java.lang.String;

public class LoopUnroller {
    long largeSum = 0;

    public void calculateLargeSum(int[] arr, int indexFrom, int indexTo) {
        // Before (unrolled):
        for(int i = indexFrom; i <= indexTo ; ++i)
            largeSum += arr[i];

        // After:
        for(int j=0; j < 2; ++j) {
            if((indexFrom + j * 2) > indexTo) break;
            largeSum += arr[(indexFrom + j * 2)];
            largeSum += arr[(indexFrom + j * 2) + 1];
        }
    }

    public static void main(String[] args) {
    }
}