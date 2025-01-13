import java.lang.String;
import javax.servlet.http.HttpServletRequest;

public class ProductController {
    public void CustomSubmit(HttpServletRequest request, String productId) {
        // Retrieve the product ID from the hidden input field
        String id = request.getParameter("productId");
        // Rest of your code to handle the delete operation
    }

    public static void main(String[] args) {
    }
}