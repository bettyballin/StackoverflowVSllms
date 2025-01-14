import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveDuplicates_1 {
    public static void main(String[] args) {
        List<String> listWithDuplicates = new ArrayList<>();
        listWithDuplicates.add("apple");
        listWithDuplicates.add("banana");
        listWithDuplicates.add("apple");
        listWithDuplicates.add("orange");

        // Using LinkedHashSet to remove duplicates and maintain order
        List<String> listWithoutDuplicates = new ArrayList<>(new LinkedHashSet<>(listWithDuplicates));

        System.out.println(listWithoutDuplicates);
    }
}