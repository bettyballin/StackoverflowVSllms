import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.PrintWriter;

public class AudiolistTableGenerator {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            // Load the database driver (e.g. MySQL Connector/J)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("select * from audiolist");
            PrintWriter out = new PrintWriter(System.out);
            int contador = 0;
            out.println("<center><table border='1'>");
            while (rs.next()) {
                contador++;
                out.println("<tr>");
                String k = rs.getString("Tittle");
                String l = rs.getString("Autor");
                String m = rs.getString("Album");
                out.println("<td><input type='radio' name='titulo' value='" + k + "'>");
                out.println("<td>" + k + "</td>");
                out.println("<td>" + l + "</td>");
                out.println("<td>" + m + "</td>");
                out.println("</tr>");
            }
            out.println("</table></center>");
            out.println("<form>");
            out.println("<tr><td colspan=2><input type=submit></td></tr>");
            out.println("</form>");
            out.flush();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}