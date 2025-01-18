import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/columns")
public class Columns extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch the columns from somewhere
        List<String> columns = fetchFromSomewhere();
        ObjectMapper objectMapper = new ObjectMapper();
        // Convert Java list to JSON array string
        String jsonArrayOfColumns = objectMapper.writeValueAsString(columns);
        response.setContentType("application/json");
        response.getWriter().print(jsonArrayOfColumns);
    }

    private List<String> fetchFromSomewhere() {
        // Dummy implementation to make the code compile
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        // Main method can be left empty or used to start a server
    }
}