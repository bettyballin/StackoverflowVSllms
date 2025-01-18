import java.util.*;

class SubListComparator implements Comparator<List<String>> {
    @Override
    public int compare(List<String> o1, List<String> o2) {
        return Integer.compare(Integer.parseInt(o1.get(1)), Integer.parseInt(o2.get(1))); // Sort by the second element in each sublist
    }
}

public class Main_89 {
    public static void main(String[] args) {
        List<List<String>> records = new ArrayList<>();
        /*...Populate Sublists and add to records list */
        Collections.sort(records, new SubListComparator()); // Sort the outer list based on the elements of its inner sublists
    }
}