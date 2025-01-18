import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "username", "password");
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select length('10385274000') as numberLength from dual");
            rset.next();
            if (rset.getInt(1) > 10) { // number exceeds the NUMBER(10) capacity when it has more than ten digits or is negative and has more nine digits, not including any decimal points
                System.out.println("The value '10385274000' is larger than NUMBER(10)");  // or raise an Exception here
            } else {
                PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO yourTable VALUES (?)");
                int columnPosition = 1; // placeholder value
                int valueToInsert = 1234567890; // placeholder value
                insertStmt.setInt(columnPosition, valueToInsert);  // assuming the column is NUMBER(10) and in Oracle integers are mapped to java int type
                insertStmt.executeUpdate(); // execute the insert
                insertStmt.close(); // close the statement
            }
            // Close resources
            rset.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}