import java.lang.String;
import java.sql.*;

public class NameFetcher {
    Connection con = null;
    String lastName = null;
    PreparedStatement ps = null;

    {
        try {
            ps = con.prepareStatement("select * from table1 where last_name like ?");
            ps.setString(1, "%" + lastName + "%");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
    }
}