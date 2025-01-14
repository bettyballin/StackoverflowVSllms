import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/loadChildren")
public class LazyLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String parentId = request.getParameter("parentId");
        String parentType = request.getParameter("parentType"); // e.g., "Country", "State", etc.

        // Your SQL query logic here to get children based on parentId and parentType
        List<Map<String, Object>> children = fetchChildrenFromDB(parentId, parentType);

        response.setContentType("application/json");
        response.setHeader("Cache-Control", "no-cache");

        PrintWriter out = response.getWriter();
        // Convert your list of children to JSON format
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(children);
        out.print(json);
    }

    private List<Map<String, Object>> fetchChildrenFromDB(String parentId, String parentType) throws ServletException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Map<String, Object>> children = new ArrayList<>();

        String sqlQuery = "";
        if ("Country".equals(parentType)) {
            // Fetch states for country
            sqlQuery = "SELECT state_id as id, state_name as name FROM states WHERE country_id=?";
        } else if ("State".equals(parentType)) {
            // Fetch cities for state
            sqlQuery = "SELECT city_id as id, city_name as name FROM cities WHERE state_id=?";
        } else if ("City".equals(parentType)) {
            // Fetch sites for city
            sqlQuery = "SELECT site_id as id, address as name, true AS leaf FROM sites WHERE city_id=?";
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "user", "password");
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setString(1, parentId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Map<String, Object> childNode = new HashMap<>();
                childNode.put("id", rs.getString("id"));
                childNode.put("name", rs.getString("name"));
                if (rs.getBoolean("leaf")) childNode.put("leaf", true);
                children.add(childNode);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        } finally {
            // Clean up resources
            try { if (rs != null) rs.close(); } catch (SQLException ignore) {}
            try { if (pstmt != null) pstmt.close(); } catch (SQLException ignore) {}
            try { if (conn != null) conn.close(); } catch (SQLException ignore) {}
        }

        return children;
    }

    public static void main(String[] args) {
    }
}