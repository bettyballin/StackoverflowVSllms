import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Example {
    public void exampleMethod() throws ApplicationException {
        try (ResultSet rs = getResultSet(); InputStream is = rs.getBinaryStream("fileData");) {
            // Your code here...
        } catch (SQLException ex) {
            Log.error(ex);
            throw new ApplicationException(ex);
        }
    }

    private ResultSet getResultSet() throws SQLException {
        // Dummy implementation for compilation purposes
        return null;
    }
}

class Log {
    public static void error(Exception ex) {
        // Log the error
        System.err.println("Error: " + ex.getMessage());
    }
}

class ApplicationException extends Exception {
    public ApplicationException(Throwable cause) {
        super(cause);
    }
}