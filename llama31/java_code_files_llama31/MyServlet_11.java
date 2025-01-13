/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet_11
extends HttpServlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM mytable");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        }
        catch (SQLException sQLException) {
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (SQLException sQLException) {}
            }
        }
    }

    public static void main(String[] stringArray) {
    }
}
