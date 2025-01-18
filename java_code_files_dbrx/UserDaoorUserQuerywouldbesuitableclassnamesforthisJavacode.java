import java.lang.String;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoorUserQuerywouldbesuitableclassnamesforthisJavacode {
    public static void main(String[] args) {
        Connection con = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT USER_ID FROM USERS WHERE USERNAME='TestUser2'");
        } catch (SQLException e) {
            // Exception handling code
        }
    }
}