import java.lang.String;
import java.sql.Connection;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class JavaSqlDriver {
    public interface Driver {
        Connection connect(String url, Properties info) throws SQLException;
        boolean acceptsURL(String url) throws SQLException;
        DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException;
        int getMajorVersion();
        int getMinorVersion();
        boolean jdbcCompliant();
        Logger getParentLogger() throws SQLFeatureNotSupportedException;
    }

    public static void main(String[] args) {
    }
}