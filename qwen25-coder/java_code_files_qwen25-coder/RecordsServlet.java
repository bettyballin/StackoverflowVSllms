import java.lang.String;
import java.lang.Integer;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/records")
public class RecordsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageSize = 100;
        int pageNumber = Integer.parseInt(request.getParameter("page")); // Get page number from request
        String query = "SELECT * FROM your_table ORDER BY some_column LIMIT ? OFFSET ?";
        
        try (Connection conn = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            int offset = (pageNumber - 1) * pageSize;
            ps.setInt(1, pageSize);
            ps.setInt(2, offset);
            
            ResultSet rs = ps.executeQuery();
            // Process ResultSet and send to view
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

	public static void main(String[] args) {
	}
}