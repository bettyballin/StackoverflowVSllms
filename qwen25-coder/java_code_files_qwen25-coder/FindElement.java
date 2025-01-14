import java.util.HashMap;
import java.util.Map;

public class FindElement {
    public static int findElement(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Since we know one element appears N/2 times
        int nByTwo = arr.length / 2;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == nByTwo) {
                return entry.getKey();
            }
        }
        
        throw new IllegalArgumentException("No element found");
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 10, 1, 4, 10, 5, 10, 10};
        System.out.println(findElement(arr)); // Output: 10
    }
}