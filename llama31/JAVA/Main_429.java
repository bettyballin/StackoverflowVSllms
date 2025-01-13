import java.lang.String;
import java.lang.Integer;
public class Main_429 {
    public static void main(String[] args) {
        int[] A = {1, 2, 5, 11, 2, 6, 8, 24, 101, 17, 8};
        int[] B = {5, 2, 11, 8, 17};
        int[] result = findWindow(A, B);
        System.out.println("i: " + result[0] + ", j: " + result[1]);
    }

    public static int[] findWindow(int[] A, int[] B) {
        int m = B.length;
        int n = A.length;
        int[] hash = new int[100000]; // assuming max value in A and B is less than 100000
        int[] indices = new int[m];

        // Initialize hash with -1
        for (int i = 0; i < hash.length; i++) {
            hash[i] = -1;
        }

        // Store the last seen index of each element in B
        for (int i = 0; i < m; i++) {
            hash[B[i]] = i;
        }

        int minLen = Integer.MAX_VALUE;
        int start = -1, end = -1;
        int count = 0;

        // Iterate over A
        for (int i = 0; i < n; i++) {
            if (hash[A[i]] != -1) {
                // If the current element is in B
                if (indices[hash[A[i]]] == 0) {
                    count++;
                }
                indices[hash[A[i]]] = i;
                if (count == m) {
                    // If all elements of B are found in A
                    int minIndex = Integer.MAX_VALUE;
                    int maxIndex = Integer.MIN_VALUE;
                    for (int j = 0; j < m; j++) {
                        minIndex = Math.min(minIndex, indices[j]);
                        maxIndex = Math.max(maxIndex, indices[j]);
                    }
                    if (maxIndex - minIndex + 1 < minLen) {
                        minLen = maxIndex - minIndex + 1;
                        start = minIndex;
                        end = maxIndex;
                    }
                }
            }
        }

        if (start == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{start, end};
    }
}