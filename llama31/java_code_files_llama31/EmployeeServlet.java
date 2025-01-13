/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.annotation.WebServlet
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value={"/employees"})
public class EmployeeServlet
extends HttpServlet {
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String string = httpServletRequest.getParameter("sortBy");
        String string2 = httpServletRequest.getParameter("sortOrder");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "username", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees ORDER BY " + string + " " + string2);
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static void main(String[] stringArray) {
    }
}
