import java.sql.*;
import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource1 = null;
        DataSource dataSource2 = null;
        Connection sourceConn = null;
        Connection targetConn = null;
        try {
            sourceConn = dataSource1.getConnection();
            targetConn = dataSource2.getConnection();
            String sql = "SELECT * FROM TableA WHERE condition";
            try (PreparedStatement preparedStatement = sourceConn.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery();
                 Statement statement = targetConn.createStatement()) {
                while (resultSet.next() != false) {
                    StringBuilder stringBuilder = new StringBuilder("INSERT INTO TableA VALUES(");
                    for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                        Object columnObject = resultSet.getObject(i);
                        if (columnObject == null) {
                            stringBuilder.append("NULL");
                        } else {
                            switch (resultSet.getMetaData().getColumnType(i)) {
                                case Types.BIGINT:
                                    long longValue = resultSet.getLong(i);
                                    stringBuilder.append(longValue).append(", ");
                                    break;
                                // Check for other data types here...
                            }
                        }
                        if (i < resultSet.getMetaData().getColumnCount()) {
                            stringBuilder.append(",");
                        } else {
                            stringBuilder.append(")");
                        }
                    }
                    statement.addBatch(stringBuilder.toString());
                }
                statement.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (sourceConn != null && !sourceConn.isClosed()) {  // Close resource.
                    try {
                        sourceConn.close();
                    } catch (Throwable ignore) {
                    }
                }
                if (targetConn != null && !targetConn.isClosed()) {  // Close resource.
                    try {
                        targetConn.close();
                    } catch (Throwable ignore) {
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}