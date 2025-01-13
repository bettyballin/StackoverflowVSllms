/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;

public class SQLInjectionValidator {
    public void validateInput(HttpServletRequest httpServletRequest) {
        String string = httpServletRequest.getParameter("username");
        if (string != null && !string.isEmpty()) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
                preparedStatement.setString(1, string);
                ResultSet resultSet = preparedStatement.executeQuery();
                connection.close();
            }
            catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static void main(String[] stringArray) {
        SQLInjectionValidator sQLInjectionValidator = new SQLInjectionValidator();
    }
}
