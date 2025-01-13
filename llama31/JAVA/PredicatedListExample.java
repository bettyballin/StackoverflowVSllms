import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicatedListExample {

    public static void main(String[] args) {
        // Creating a list
        List<Object> list = new ArrayList<>();
        
        // Adding null to the list
        list.add(null);
        
        // Filtering out null values using a custom predicate and Stream API
        List<Object> filteredList = list.stream()
                .filter(Predicate.not(item -> item == null))
                .collect(Collectors.toList());
        
        // Demonstrating that the filtered list is empty because null was filtered out
        System.out.println("List size after filtering null: " + filteredList.size());
    }
}