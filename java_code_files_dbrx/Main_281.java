import java.sql.*;
public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/database";
        String user = "username";
        String password = "password";
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT COUNT(*) FROM `table`";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            int CountOfTables = 0;
            if (rs.next()) {
                CountOfTables = rs.getInt("COUNT(*)");
            }
            System.out.println("Size of Result Set is : " + CountOfTables);
        } catch (SQLException ex) {
            // Exception handling here.
        }
    }
}