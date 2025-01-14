import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.google.gson.Gson;
import java.util.HashMap;

@WebServlet("/data")
public class DataServlet_3 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create a simple data model
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap.put("name", "John Doe");
        dataMap.put("age", 30);

        Gson gson = new Gson();
        String jsonData = gson.toJson(dataMap);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonData);
    }

    public static void main(String[] args) {
    }
}