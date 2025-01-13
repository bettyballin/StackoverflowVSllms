import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/data/*")
public class DataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        String dataType = req.getPathInfo(); // get the request type from the URL
        switch (dataType) {
            case "/users":
                // handle user data request
                break;
            case "/products":
                // handle product data request
                break;
            // add more cases as needed
            default:
                try {
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                } catch (IOException e) {
                    // Handle exception
                }
        }
    }

    public static void main(String[] args) {
    }
}