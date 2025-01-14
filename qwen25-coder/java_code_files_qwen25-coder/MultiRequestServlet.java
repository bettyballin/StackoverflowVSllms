import java.lang.String;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MultiRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        switch (path) {
            case "/data1":
                handleData1(request, response);
                break;
            case "/data2":
                handleData2(request, response);
                break;
            // Add more cases as necessary
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void handleData1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Logic to handle data1 request
        response.getWriter().write("Data 1");
    }

    private void handleData2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Logic to handle data2 request
        response.getWriter().write("Data 2");
    }

	public static void main(String[] args) {
	}
}