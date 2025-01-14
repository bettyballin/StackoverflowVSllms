import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class ReverseItems {

    public void reverseItems(HttpServletRequest request, List<?> items) {
        // Assuming 'items' is your original list
        Collections.reverse(items);

        // Set the reversed list as a request attribute
        request.setAttribute("reversedItems", items);
    }
}