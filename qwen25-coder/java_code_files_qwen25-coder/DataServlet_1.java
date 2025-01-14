import java.lang.String;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/api/data")
public class DataServlet_1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        
        String url="jdbc:mysql://localhost:3306/your_database?useSSL=false";
        String user="your_username";
        String password="your_password";

        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM your_table");
             ResultSet rs = stmt.executeQuery()) {
            out.println("[");
            boolean firstRow = true;
            while(rs.next()){
                if(firstRow) firstRow=false; else out.print(",");
                out.printf("{\"id\":\"%s\",\"value\":\"%s\"}", rs.getString("id"), rs.getString("value"));
            }
            out.println("]");
        } catch (SQLException e) {
            out.println("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    public static void main(String[] args) {
    }
}