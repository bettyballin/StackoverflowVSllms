import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Clob;
import java.sql.SQLException;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LogAppender {

    public static void main(String[] args) {
        // Assign initial values & establish connection
        long id = 42; // replace it with actual user_id or object id in your code logic.
        String newLogContent = "Some important long log text here..."; // appending content...
        Connection conn = createYourJDBCConnection(); // implement method to get DB connection!

        try (PreparedStatement preparedSelect = conn.prepareStatement("SELECT log FROM table WHERE id=? FOR UPDATE NOWAIT")) {
            preparedSelect.setLong(1, id);
            try (ResultSet rs = preparedSelect.executeQuery()) {
                Clob oldLogContentClob = null; // declare as a CLOB variable.

                if (rs.next()) {
                    oldLogContentClob = createFromTypeOfOldAndNewMergeMethod();// depends on your type of DB implementation such as Oracle, MSSQL, PostgreSQL etc.

                    if (oldLogContentClob != null) {
                        // get the current content stream for reading...
                        Writer clobWriter = oldLogContentClob.setCharacterStream(1L);// use either setAsciiOutputStream or setCharacterStream depending on encoding support!

                        // copy existing logs from previous clob to buffer reader first before merging with new log content as required!
                        try (BufferedReader br = new BufferedReader(new InputStreamReader(oldLogContentClob.getAsciiStream()))) {
                            String bufferingLinedData = "";
                            while ((bufferingLinedData = br.readLine()) != null) {// merge/append existing line contents!
                                clobWriter.write(bufferingLinedData); // write to buffer writer.
                                // clobWriter.write("\n"); // if you want to append a newline or not... depends on your use case!
                            }
                        }
                    } else { // for handling the null condition when initial old clob is null or empty!
                        oldLogContentClob = createYourEmptyCLOBInstanceHereUsingCorrectJDBCImpOfType(); // implement this method to return a new instance of your database type supporting CLOBS like Oracle/MS-SQL etc.
                    }
                } else { // Handle if no value is found for the given id!
                    oldLogContentClob = createYourEmptyCLOBInstanceHereUsingCorrectJDBCImpOfType(); // implement this method to return a new instance of your database type supporting CLOBS like Oracle/MS-SQL etc.
                }

                // Append or merge with newly generated log contents...
                Writer clobWriter = oldLogContentClob.setCharacterStream(1L); // use either setAsciiOutputStream or setCharacterStream depending on encoding support!
                clobWriter.write("\n" + newLogContent); // add a newline and append the content to it!
                // ... // write rest of your data processing code here if any left...
            } catch (IOException e) {
                throw new RuntimeException("Error reading CLOB", e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } // Close the connection, don't forget this part it is very critical and must always be done after completing your tasks!
        }
    }

    private static Connection createYourJDBCConnection() {
        // Implement method to get DB connection
        return null; // Placeholder
    }

    private static Clob createFromTypeOfOldAndNewMergeMethod() {
        // Implement this method based on your DB implementation
        return null; // Placeholder
    }

    private static Clob createYourEmptyCLOBInstanceHereUsingCorrectJDBCImpOfType() {
        // Implement this method to return a new instance of your database type supporting CLOBS
        return null; // Placeholder
    }
}