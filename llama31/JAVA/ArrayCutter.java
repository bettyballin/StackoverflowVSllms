import java.lang.String;
public class ArrayCutter {
    public static int cutArray(int[] arr, int start, int sumLeft, int sumRight) {
        if (start >= arr.length) {
            return sumLeft == sumRight ? arr.length - 1 : -1;
        }
        int current = arr[start];
        sumLeft += current;
        sumRight -= current;
        int result = cutArray(arr, start + 1, sumLeft, sumRight);
        if (result != -1) {
            return result;
        }
        sumLeft -= current;
        sumRight += current;
        return cutArray(arr, start + 1, sumLeft, sumRight);
    }

    public static int cutArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return cutArray(arr, 0, 0, sum);
    }

	public static void main(String[] args) {
	}
}