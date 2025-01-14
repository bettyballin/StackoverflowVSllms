import com.sun.rowset.CachedRowSetImpl;

import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;

public class CustomCachedRowSet extends CachedRowSetImpl {

    @Override
    public void populate(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        
        int columnCount = metaData.getColumnCount();
        while (rs.next()) {
            this.moveToInsertRow();
            for (int i = 1; i <= columnCount; i++) {
                // Check if scale is negative and adjust accordingly
                if (metaData.getScale(i) < 0 && metaData.getPrecision(i) > 0) {
                    Object value = rs.getObject(i);
                    this.updateObject(i, value);
                } else {
                    Object value = rs.getObject(i);
                    this.updateObject(i, value);
                }
            }
            this.insertRow();
            this.moveToCurrentRow();
        }
    }

    public static void main(String[] args) {
    }
}