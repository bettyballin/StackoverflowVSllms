import java.util.ArrayList;
import java.util.List;

public class Main_221 {
    public static void main(String[] args) {
        List<Object> originalList = new ArrayList<>();
        originalList.add("Element 1");
        originalList.add("Element 2");
        originalList.add("Element 3");

        List<Object> alreadyProcessed = new ArrayList<>();

        while (!originalList.isEmpty()) {
            Object element = originalList.remove(0);
            // Process the element
            System.out.println("Processing element: " + element);
            alreadyProcessed.add(element);
        }

        System.out.println("Already processed elements: " + alreadyProcessed);
    }
}