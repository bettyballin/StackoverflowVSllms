import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class DatabaseQueryExecutor_8_8 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
        crs.setCommand("SELECT * FROM your_table");
        crs.setDataSourceName("your_datasource_name");
        crs.setNLSCharset("US-ASCII"); // or the actual character set used by your database
        crs.execute();
    }
}