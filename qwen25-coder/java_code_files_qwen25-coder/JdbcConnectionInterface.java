import java.lang.String;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.Wrapper;
import java.sql.SQLException;
import java.lang.AutoCloseable;

public class JdbcConnectionInterface {
    public interface Connection extends Wrapper, AutoCloseable {
          Statement createStatement() throws SQLException;
          PreparedStatement prepareStatement(String sql) throws SQLException;
          CallableStatement prepareCall(String sql) throws SQLException;
          // More methods...
      }

    public static void main(String[] args) {
    }
}