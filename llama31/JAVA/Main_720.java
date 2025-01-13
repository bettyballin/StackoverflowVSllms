import java.util.HashMap;
import java.util.Map;

public class Main_720_720 {
    public static boolean checkMode(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int freq : freqMap.values()) {
            if (freq >= n / k) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        int k = 3;
        System.out.println(checkMode(arr, k)); // prints: true
    }
}