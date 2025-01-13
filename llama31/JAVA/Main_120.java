// Assuming you are using MySQL Connector/J
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main_120 {
    public static void main(String[] args) throws Exception {
        // Load the MySQL Connector/J driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "youruser", "yourpassword");

        PreparedStatement pstmt = conn.prepareStatement("SELECT date, associate_id, COUNT(*) as per_date FROM tracking GROUP BY date, associate_id ORDER BY date");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            // Process the results
            System.out.println(rs.getString("date") + " " + rs.getInt("associate_id") + " " + rs.getInt("per_date"));
        }

        rs.close();
        pstmt.close();

        PreparedStatement pstmtDistinct = conn.prepareStatement("SELECT DISTINCT associate_id FROM tracking");
        ResultSet rsDistinct = pstmtDistinct.executeQuery();

        while (rsDistinct.next()) {
            // Process the distinct associate_ids
            System.out.println(rsDistinct.getInt("associate_id"));
        }

        rsDistinct.close();
        pstmtDistinct.close();

        conn.close();
    }
}