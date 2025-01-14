import java.util.List;
import java.util.ArrayList;

public class PixieSwampExplorer {
    public static List<Integer> findCustards(int size) {
        List<Integer> custards = new ArrayList<>();
        
        // Binary search to divide the map into sections and find custard points.
        int start = 0;
        int end = size - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            boolean[] swoopMap = new boolean[size];
            for (int i = start; i <= mid; i++) {
                swoopMap[i] = true; // Swoops down from start to mid
            }
            
            if (!flutter(swoopMap)) { // If pixie did not make it, custard is in this part
                end = mid - 1;
                for (int i = start; i <= mid; i++) {
                    swoopMap[i] = false; // Test individually from start to mid
                    if (!flutter(swoopMap)) {
                        custards.add(i);
                    }
                    swoopMap[i] = true;
                }
            } else { // If pixie made it, check the other half
                for (int i = start; i <= mid; i++) {
                    swoopMap[i] = false; // Ensure no swoops from start to mid
                }
                if (!flutter(swoopMap)) { // If not clear, we have custards at end points or in between
                    start = mid + 1;
                } else {
                    start = mid + 1; // Move start past mid since it's clear up to mid
                }
            }
        }
        
        return custards;
    }

    public static void main(String[] args) {
        int size = 10; // Example swamp size
        List<Integer> custardPositions = findCustards(size);
        System.out.println("Custard positions: " + custardPositions);
    }

    // Simulated flutter function based on problem description.
    public static boolean flutter(boolean[] swoopMap) {
        // This would be replaced by actual flutter logic and return true if no custard interference
        int[] custardPositions = {0, 9}; // Example custard positions
        for (int i : custardPositions) {
            if (swoopMap[i]) return false;
        }
        return true;
    }
}