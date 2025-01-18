import java.lang.String;

public class ErrorHandlingTemplate {

    private static SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate();
    private static String SQL = "SELECT 1";

    static {
        try {
            simpleJdbcTemplate.queryForInt(SQL, null);
        } catch (DataAccessException e) {
            throw new CustomRuntimeException("An error occurred", e);
        }
    }

    public static void main(String[] args) {
    }
}

class SimpleJdbcTemplate {
    public int queryForInt(String sql, Object[] args) throws DataAccessException {
        // Dummy implementation
        return 0;
    }
}

class DataAccessException extends Exception {
    public DataAccessException(String message) {
        super(message);
    }
    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}

class CustomRuntimeException extends RuntimeException {
    public CustomRuntimeException(String message) {
        super(message);
    }
    public CustomRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}