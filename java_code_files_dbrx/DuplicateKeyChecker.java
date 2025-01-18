import java.lang.String;
import java.sql.*;

public class DuplicateKeyChecker {
    public static boolean isDuplicate(SQLException e) {
        return e.getMessage().contains("unique constraint") ||
               e.getMessage().contains("UNIQUE KEY") ||
               e.getMessage().contains("unique index");
    }

	public static void main(String[] args) {
	}
}