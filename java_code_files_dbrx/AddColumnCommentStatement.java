import java.sql.*;

public class AddColumnCommentStatement {
    String tableName = "table_name";
    Connection con;

    public AddColumnCommentStatement(Connection con) {
        this.con = con;

        try {
            DatabaseMetaData dbmd = con.getMetaData(); // Get database metadata

            try (PreparedStatement smt = con.prepareStatement(
                    "ALTER TABLE " + dbmd.quoteIdentifier(tableName) +
                    " CHANGE COLUMN c1 c VARCHAR(255) COMMENT 'this is the column description'")) {
                smt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Issue with adding comments.");
                throw new RuntimeException(e); // or handle exception appropriately
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection con = null;
        // Initialize the connection 'con' as per your database configuration
        // For example:
        // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_name", "user", "password");

        AddColumnCommentStatement accs = new AddColumnCommentStatement(con);
    }
}