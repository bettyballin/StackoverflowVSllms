import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/downloadCSV.csv")
public class DownloadCSV extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        // Prepare your csv data and set the output
        String csv = "1,2,3\n4,5,6"; // placeholder for prepared csv string
        try (PrintWriter out = response.getWriter()) {
            out.println(csv);
        }
    }
}