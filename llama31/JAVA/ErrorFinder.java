import java.util.Map;
import java.util.HashMap;

public class ErrorFinder {
    public static int[] findError(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; ++i) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            } else {
                map.put(A[i], map.get(A[i]) + 1);
            }
        }
        for (int i = 0; i < B.length; ++i) {
            if (map.containsKey(B[i])) {
                map.put(B[i], map.get(B[i]) - 1);
                if (map.get(B[i]) == 0) {
                    map.remove(B[i]);
                }
            }
        }
        int[] C = new int[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            C[i++] = entry.getKey();
        }
        return C;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {1, 2, 3};
        int[] result = findError(A, B);
        for (int i : result) {
            System.out.println(i);
        }
    }
}