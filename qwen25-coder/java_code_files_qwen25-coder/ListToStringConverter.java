import java.util.ArrayList;
import java.util.List;

public class ListToStringConverter {
    List<String> sList = new ArrayList<>();
    // add elements

    public ListToStringConverter() {
        // Initialize the list with some elements if necessary
        // sList.add("element1");
        // sList.add("element2");
        
        if (sList != null && !sList.isEmpty()) {
            StringBuilder listString = new StringBuilder();
            for (int i = 0; i < sList.size(); i++) {
                listString.append(sList.get(i));
                if (i < sList.size() - 1) {
                    listString.append(", "); // or any delimiter you choose
                }
            }
            // Optionally, use the listString here
            // System.out.println(listString.toString());
        }
    }

    public static void main(String[] args) {
        new ListToStringConverter();
    }
}