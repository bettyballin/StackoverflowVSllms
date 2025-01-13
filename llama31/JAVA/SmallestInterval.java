import java.util.Arrays;

public class SmallestInterval {
    public static void findSmallestInterval(int[] v, int N) {
        int n = v.length;
        int[] diff = new int[n];

        // Sort values in ascending order
        Arrays.sort(v);

        // Calculate differences between consecutive values
        for (int i = 0; i < n; i++) {
            diff[i] = (v[(i + 1) % n] - v[i] + N) % N;
        }

        // Find maximum difference
        int maxDiff = 0;
        int maxDiffIndex = 0;
        for (int i = 0; i < n; i++) {
            if (diff[i] > maxDiff) {
                maxDiff = diff[i];
                maxDiffIndex = i;
            }
        }

        // Calculate center and radius of smallest interval
        int c = (v[maxDiffIndex] + v[(maxDiffIndex + 1) % n] + N) / 2;
        int d = maxDiff / 2;

        System.out.println("Smallest interval: [" + (c - d) + ", " + (c + d) + "]");
    }

	public static void main(String[] args) {
        int[] v = {1, 2, 3, 4, 5};
        int N = 10;
        findSmallestInterval(v, N);
	}
}