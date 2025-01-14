import java.lang.String;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String criteria = request.getParameter("criteria");
        StringBuilder result = new StringBuilder();

        try (Connection conn = DriverManager.getConnection("jdbc:your_database_url", "user", "password");
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reports WHERE criteria_column LIKE ?")) {

            stmt.setString(1, "%" + criteria + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.append("<p>").append(rs.getString("report_name")).append("</p>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.append("An error occurred.");
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print(result.toString());
    }

	public static void main(String[] args) {
	}
}