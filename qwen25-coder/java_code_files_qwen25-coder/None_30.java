import java.lang.String;
import java.sql.ResultSet;
import java.sql.SQLException;

public class None_30 {
    public static void main(String[] args) throws SQLException {
        int contador = 0;
        ResultSet rs = null; // Placeholder for ResultSet
        java.io.PrintStream out = System.out;

        while (rs.next()) {
            contador++;
            out.println("<tr>");
            String k = rs.getString("Tittle");
            String l = rs.getString("Autor");
            String m = rs.getString("Album");
            // Use the same name for each radio button to group them
            out.println("<td><input type=\"radio\" name=\"titulo\" value=\"" + k + "\"></td>");
            out.println("<td>" + k + "</td>");
            out.println("<td>" + l + "</td>");
            out.println("<td>" + m + "</td>");
            out.println("</tr>");
        }
        out.println("</table></center>");
        out.println("<input type=\"submit\" value=\"Submit\"></form>");
    }
}