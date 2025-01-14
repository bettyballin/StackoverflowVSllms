import java.lang.String;
import java.lang.Integer;
import java.util.PriorityQueue;

public class CostedSort {
    public static int minimalCost(int[] array) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add all elements to the min-heap
        for (int num : array) {
            minHeap.add(num);
        }
        
        int totalCost = 0;
        
        // While there is more than one element in the heap
        while (minHeap.size() > 1) {
            // Extract two smallest elements
            int firstMin = minHeap.poll();
            int secondMin = minHeap.poll();
            
            // Calculate their cost and add to total
            int cost = firstMin + secondMin;
            totalCost += cost;
            
            // Insert the sum back into the heap
            minHeap.add(cost);
        }
        
        return totalCost;
    }
    
    public static void main(String[] args) {
        int[] sequence = {3, 2, 1};
        System.out.println("Minimal Cost: " + minimalCost(sequence)); // Output should be 9
    }
}