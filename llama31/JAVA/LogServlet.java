import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Assuming you're using JDBC to connect to your database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String DB_USER = "myuser";
    private static final String DB_PASSWORD = "mypassword";

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        int pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
        int rowsPerPage = 10; // adjust as needed

        // Calculate the offset for the SQL query
        int offset = (pageNumber - 1) * rowsPerPage;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // SQL query with pagination
            String query = "SELECT * FROM log_entries ORDER BY id DESC LIMIT ? OFFSET ?";

            // Prepare the statement
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, rowsPerPage);
            pstmt.setInt(2, offset);

            // Execute the query and store the results
            ResultSet results = pstmt.executeQuery();

            // Store the results in a list
            List<LogEntry> logEntries = new ArrayList<>();
            while (results.next()) {
                LogEntry logEntry = new LogEntry();
                logEntry.setId(results.getInt("id"));
                logEntry.setMessage(results.getString("message"));
                // ...
                logEntries.add(logEntry);
            }

            // Set the list as a request attribute
            req.setAttribute("logEntries", logEntries);

            // Forward to the JSP
            RequestDispatcher dispatcher = req.getRequestDispatcher("/log.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    public static void main(String[] args) {
    }
}

class LogEntry {
    private int id;
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}