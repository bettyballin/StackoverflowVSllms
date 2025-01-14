import java.util.ArrayList;
import java.util.List;

public class ListSplitter {
    /**
     * Split a list into two sublists. The original list will be modified to
     * have size i and will contain exactly the same elements at indices 0 
     * through i-1 as it had originally; the returned list will have size 
     * len-i (where len is the size of the original list before the call) 
     * and will have the same elements at indices 0 through len-(i+1) as 
     * the original list had at indices i through len-1.
     */
    public static <T> List<T> split(List<T> list, int i) {
        if (list == null || i < 0 || i > list.size()) {
            throw new IllegalArgumentException("Invalid list or index");
        }
        
        // Create a sublist from the original list starting at index i
        List<T> secondList = new ArrayList<>(list.subList(i, list.size()));
        
        // Resize the original list to contain elements up to index i
        for (int j = list.size() - 1; j >= i; j--) {
            list.remove(j);
        }
        
        return secondList;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        
        System.out.println("Original list: " + numbers);
        List<Integer> secondHalf = split(numbers, 5);
        
        System.out.println("First sublist: " + numbers);
        System.out.println("Second sublist: " + secondHalf);
    }
}