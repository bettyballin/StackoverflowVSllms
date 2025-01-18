import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyClass {
    public static void main(String[] args) {
        try {
            CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            int rowNum = 1; // The number of your targeted row.
            cachedRowSet.absolute(rowNum);
            int columnIndex = 1; // The index of your targeted column.
            ResultSet originalRow = cachedRowSet.getOriginal();
            Object value = originalRow.getObject(columnIndex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}