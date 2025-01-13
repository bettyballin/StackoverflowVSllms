/*
 * Decompiled with CFR 0.152.
 */
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AudiolistTableGenerator {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from audiolist");
            PrintWriter printWriter = new PrintWriter(System.out);
            int n = 0;
            printWriter.println("<center><table border='1'>");
            while (resultSet.next()) {
                ++n;
                printWriter.println("<tr>");
                String string = resultSet.getString("Tittle");
                String string2 = resultSet.getString("Autor");
                String string3 = resultSet.getString("Album");
                printWriter.println("<td><input type='radio' name='titulo' value='" + string + "'>");
                printWriter.println("<td>" + string + "</td>");
                printWriter.println("<td>" + string2 + "</td>");
                printWriter.println("<td>" + string3 + "</td>");
                printWriter.println("</tr>");
            }
            printWriter.println("</table></center>");
            printWriter.println("<form>");
            printWriter.println("<tr><td colspan=2><input type=submit></td></tr>");
            printWriter.println("</form>");
            printWriter.flush();
        }
        catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }
            catch (Exception exception) {
                System.out.println("Error closing connection: " + exception.getMessage());
            }
        }
    }
}
