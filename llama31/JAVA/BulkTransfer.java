import java.sql.*;

public class BulkTransfer {
  public static void main(String[] args) throws SQLException {
    // Connect to DB1
    Connection conn1 = DriverManager.getConnection("jdbc:oracle:thin:@db1", "user1", "password1");

    // Connect to DB2
    Connection conn2 = DriverManager.getConnection("jdbc:oracle:thin:@db2", "user2", "password2");

    // Create a statement on DB1
    Statement stmt1 = conn1.createStatement();

    // Create a statement on DB2
    Statement stmt2 = conn2.createStatement();

    // Select data from DB1
    ResultSet rs = stmt1.executeQuery("SELECT column1, column2 FROM TABLE_A WHERE filter_condition");

    // Insert data into DB2
    PreparedStatement pstmt = conn2.prepareStatement("INSERT INTO TABLE_A (column1, column2) VALUES (?, ?)");
    while (rs.next()) {
      pstmt.setString(1, rs.getString(1));
      pstmt.setString(2, rs.getString(2));
      pstmt.executeUpdate();
    }

    // Close resources
    rs.close();
    pstmt.close();
    stmt1.close();
    stmt2.close();
    conn1.close();
    conn2.close();
  }
}