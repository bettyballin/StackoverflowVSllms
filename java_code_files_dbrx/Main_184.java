import java.sql.*;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleStatement;

public class Main_184 {
    public static void main(String args[]) throws Exception {
        // Register the driver
        Class.forName("oracle.jdbc.OracleDriver");
        // Get a connection to the database
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@oracleDataSource", "username", "password");
        // Set auto commit to false for transaction control
        conn.setAutoCommit(false);

        Statement statement = (OracleStatement) conn.createStatement();
        PreparedStatement pstmt = null;

        String sqlInsert = "INSERT INTO TABLE_NAME (CLOB_COLUMN) VALUES(?)";
        // Prepare the statement
        pstmt = (OraclePreparedStatement) conn.prepareStatement(sqlInsert);
        Clob clobValue = ((OracleConnection) conn).createClob();
        try {
            clobValue.setString(1, "YOUR_CLOB_DATA"); // Insert your CLOB data here
            pstmt.setClob(1, clobValue);
            int rowsAffected = statement.executeUpdate(sqlInsert);
            if (rowsAffected > 0) {
                System.out.println("The number of inserted or updated is : " + rowsAffected);
            } else {
                /* Something went wrong! -- Handle the error */
            }
            conn.commit(); // commit your work to database
        } catch (SQLException e2) {
            e2.printStackTrace(); // Handle SQL Exception Here..
            try {
                conn.rollback(); // if something wrong, roll back the change
            } catch (SQLException sqlExcep) {
                sqlExcep.printStackTrace(); // handle error when rolling back changes.
            }
            conn.setAutoCommit(true); // Reset auto commit value to true before exit
        } catch (Exception ex) {
            System.out.println("Unable To Insert/Update CLOB column" + ex.getMessage());
            conn.setAutoCommit(true); // Reset auto commit value to true before exit
        } finally { // Closing Oracle DB resources .....
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException sqlEx) {
                /* IGNORED */
            }
            pstmt = null;
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sqlEx) {
                /*IGNORED*/
            }
            conn = null;
        }
    }
}