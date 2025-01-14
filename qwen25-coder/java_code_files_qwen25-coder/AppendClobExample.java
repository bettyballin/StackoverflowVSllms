import java.sql.*;
import java.io.*;
import oracle.jdbc.*;

public class AppendClobExample {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//your_database_host/your_database_service";
        String user = "your_username";
        String password = "your_password";

        Connection connection = null;
        CallableStatement cs = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false); // Set auto-commit to false

            // Prepare the SQL statement with a placeholder for the CLOB
            String sql = "UPDATE your_table SET log=EMPTY_CLOB() WHERE id=? RETURNING log INTO ?";
            cs = connection.prepareCall(sql);

            Long id = 1L; // Example ID
            cs.setLong(1, id);
            cs.registerOutParameter(2, java.sql.Types.CLOB);

            // Execute the update
            cs.executeUpdate();

            // Retrieve the CLOB
            Clob clob = cs.getClob(2); // Get the CLOB object

            Writer clobWriter = clob.setCharacterStream(clob.length() + 1); // Append at the end
            BufferedReader reader = new BufferedReader(new FileReader("path_to_your_large_text_file_or_string"));

            String line;
            while ((line = reader.readLine()) != null) {
                clobWriter.write(line);
                clobWriter.newLine();
            }

            // Close the writer and reader
            clobWriter.close();
            reader.close();

            connection.commit(); // Commit the transaction

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback changes in case of an error
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            try {
                if (cs != null) cs.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}