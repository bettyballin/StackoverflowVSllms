import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main_811 {
    public static void main(String[] args) throws Exception {
        // assuming you have a Connection object named conn
        Connection conn = DriverManager.getConnection("url", "user", "password");

        String user_input = "username"; // replace with actual user input

        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE name = ?");
        pstmt.setString(1, user_input);
        ResultSet rs = pstmt.executeQuery();

        // you may want to process the result set
        while (rs.next()) {
            System.out.println(rs.getString(1)); // print the first column
        }

        rs.close();
        pstmt.close();
        conn.close();
    }
}