import java.io.IOException;
import java.util.Hashtable;

public class CategoryCountForwarder {

    private CategoryCountManager categoryCountManager;

    public CategoryCountForwarder() {
        // initialize the categoryCountManager here
        categoryCountManager = new CategoryCountManager();
    }

    public void forwardRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Hashtable<String, Hashtable<String, Integer>> hash = categoryCountManager.getFunctionWithSubFunctionCount(1L);
        request.setAttribute("categoryDetails", hash);
        RequestDispatcher dispatcher = request.getRequestDispatcher("yourJspPage.jsp");
        dispatcher.forward(request, response);
    }

    public static void main(String[] args) {
        // Main method implementation (if needed)
    }
}

class CategoryCountManager {
    public Hashtable<String, Hashtable<String, Integer>> getFunctionWithSubFunctionCount(Long l) {
        // Return an empty Hashtable for demonstration purposes
        return new Hashtable<String, Hashtable<String, Integer>>();
    }
}

interface HttpServletRequest {
    void setAttribute(String name, Object o);
    RequestDispatcher getRequestDispatcher(String path);
}

interface HttpServletResponse {
    // Methods can be added as needed
}

interface RequestDispatcher {
    void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}

class ServletException extends Exception {
    // Exception implementation
}