import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import org.json.JSONArray;
import org.json.JSONObject;

// Server-side servlet
@WebServlet("/query")
public class QueryServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    try {
      // Connect to MySQL database
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");

      // Return results as JSON
      JSONArray results = new JSONArray();
      while (rs.next()) {
        JSONObject row = new JSONObject();
        row.put("id", rs.getInt("id"));
        row.put("name", rs.getString("name"));
        results.put(row); // Changed from add to put
      }
      resp.setContentType("application/json");
      resp.getWriter().print(results.toString());
    } catch (Exception e) {
      // Handle exception
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void main(String[] args) {
  }
}