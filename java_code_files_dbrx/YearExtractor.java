import java.sql.*;
import javax.swing.*;

public class YearExtractor {
    public static void main(String[] args) {
        try {
            Connection connection = null; // Assume connection is obtained elsewhere
            JComboBox jComboBox = new JComboBox();

            String sql = "SELECT EXTRACT(YEAR FROM date_column) AS yearValue " +
                         "FROM tableName GROUP BY yearValue";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int extractedYear = rs.getInt("yearValue"); // Change according to your column index or name
                jComboBox.addItem(extractedYear);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}