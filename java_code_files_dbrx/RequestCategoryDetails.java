import java.util.HashMap;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

public class RequestCategoryDetails {
    @Inject private transient HttpServletRequest request; // In case of CDI
    // or autowire HttpServletRequest if using Spring MVC etc.
    
    public RequestCategoryDetails() {
        Object category = this.request.getAttribute("categoryDetails");
        HashMap<String, HashMap<String, Integer>> cat = (HashMap<String, HashMap<String, Integer>>) category;
        // Other initializations...
    }
    
    public static void main(String[] args) {
    }
}