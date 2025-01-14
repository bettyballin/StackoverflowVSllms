import java.lang.String;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CSVImportToDB {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/yourDatabase";
        String username = "username";
        String password = "password";
        String csvFilePath = "output.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {

            // Skip headers
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String sql = "INSERT INTO yourTable (column1, column2, column3) VALUES (?, ?, ?)";
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    for (int i = 0; i < values.length; i++) {
                        ps.setString(i + 1, values[i]);
                    }
                    ps.executeUpdate();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}