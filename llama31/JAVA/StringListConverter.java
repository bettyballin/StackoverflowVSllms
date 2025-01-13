import java.util.List;
import java.util.ArrayList;

public class StringListConverter {
    public static void main(String[] args) {
        List<String> sList = new ArrayList<String>();
        // add elements
        sList.add("Element 1");
        sList.add("Element 2");
        sList.add("Element 3");

        if (sList != null) {
            StringBuilder sb = new StringBuilder();
            for (String str : sList) {
                sb.append(str).append(",");
            }
            // Remove the trailing comma
            String listString = sb.toString().replaceAll(",$", "");
            System.out.println(listString);
        }
    }
}