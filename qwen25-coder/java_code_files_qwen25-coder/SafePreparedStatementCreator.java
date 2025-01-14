import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SafePreparedStatementCreator {
    String sql = "SELECT * FROM table WHERE id = ?";
    PreparedStatement pstmt;
    Connection connection = null;
    int userInputID = 0;

    {
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, userInputID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}