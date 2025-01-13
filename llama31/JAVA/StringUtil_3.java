import java.util.List;
import java.util.ArrayList;

public class StringUtil_3_3 {
    public static void main(String[] args) {
        List<String> sList = new ArrayList<String>();
        // add elements
        sList.add("Element1");
        sList.add("Element2");
        sList.add("Element3");

        if (sList != null) {
            String listString = String.join(",", sList);
            System.out.println(listString);
        }
    }
}