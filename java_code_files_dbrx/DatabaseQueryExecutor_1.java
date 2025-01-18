import java.sql.*;

public class DatabaseQueryExecutor_1 {
    private Connection connection;

    public String getCell(String sql, String[] parameters) {
        String out = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.length; i++) { // loop from 0 to length -1
                String parameter = parameters[i];
                ps.setString(i + 1, parameter); // index in setString method is 1 based not 0 based
            }
            ResultSet rs = ps.executeQuery();
            if (rs.next()) { // check if there is actually a result with rs.next() before getting the value
                out = rs.getString(1);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
    }

    public static void main(String[] args) {
    }
}