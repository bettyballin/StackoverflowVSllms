import java.sql.*;
public class Main_282 {
    public static void main(String[] args) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/database";
        String user = "username";
        String password = "password";
        // Assume we have already created the connection object.
        try (Connection con = DriverManager.getConnection(url, user, password)){
            String query =  "SELECT * FROM table";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            int count=0;
            while (rs.next()) {
                   count++;
            }
            System.out.println("Size of Result Set is : " + count) ;
        } catch (SQLException ex) {
            // Exception handling here.
        } finally {
            // close all the connections and statements here as applicable.
        }
    }
}