import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<String> listWithDuplicates = new ArrayList<>();
        listWithDuplicates.add("apple");
        listWithDuplicates.add("banana");
        listWithDuplicates.add("apple");
        listWithDuplicates.add("orange");

        // Using HashSet to remove duplicates
        List<String> listWithoutDuplicates = new ArrayList<>(new HashSet<>(listWithDuplicates));

        System.out.println(listWithoutDuplicates);
    }
}