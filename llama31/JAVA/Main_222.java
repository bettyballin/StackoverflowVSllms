import java.util.*;

public class Main_222 {
    public static void main(String[] args) {
        List<String> originalList = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry"));
        Iterator<String> iterator = originalList.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("Processing element: " + element);
            // Process the element
            if (element.equals("Cherry")) {
                iterator.remove();
            }
        }

        System.out.println("List after removal: " + originalList);
    }
}