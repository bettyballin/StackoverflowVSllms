import java.sql.SQLException;

public class SQLExceptionHandler {
    public static void main(String[] args) {
        SQLException sqlException = new SQLException();
        String sqlState = sqlException.getSQLState();
        int errorCode = sqlException.getErrorCode();
    }
}