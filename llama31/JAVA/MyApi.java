import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Path("/api")
public class MyApi {
    @GET
    @Path("/sp")
    @Produces(MediaType.APPLICATION_JSON)
    public String callSP(@QueryParam("inputParam") String inputParam) {
        // Connect to the database
        Connection conn = null;
        Statement stmt = null;
        ResultSet result = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");

            // Create a statement and call the stored procedure
            stmt = conn.createStatement();
            result = stmt.executeQuery("CALL MY_SP('" + inputParam + "')");

            // Process the result and return it as JSON
            String jsonResult = processResult(result);
            return jsonResult;
        } catch (Exception e) {
            return "{\"error\":\"" + e.getMessage() + "\"}";
        } finally {
            try {
                if (result != null) result.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                return "{\"error\":\"" + e.getMessage() + "\"}";
            }
        }
    }

    private String processResult(ResultSet result) {
        // Implement logic to convert the ResultSet to a JSON string
        // For example:
        StringBuilder json = new StringBuilder("[");
        try {
            while (result.next()) {
                json.append("{\"column1\":\"").append(result.getString(1)).append("\"}");
                if (!result.isLast()) json.append(",");
            }
        } catch (Exception e) {
            return "{\"error\":\"" + e.getMessage() + "\"}";
        }
        json.append("]");
        return json.toString();
    }

    public static void main(String[] args) {
        // This main method is not needed for the JAX-RS API to work, but it can be used for testing
        MyApi api = new MyApi();
        System.out.println(api.callSP("test"));
    }
}