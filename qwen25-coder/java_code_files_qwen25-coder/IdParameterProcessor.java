import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IdParameterProcessor {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("id");
        if (ids != null && !ids.isEmpty()) {
            String[] idArray = ids.split(",");
            // Now you can process each id from the array
            for (String id : idArray) {
                System.out.println("Processing ID: " + id);
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "No 'id' parameter provided");
        }
    }
    public static void main(String[] args) {
    }
}