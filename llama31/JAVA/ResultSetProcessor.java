import java.lang.String;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetProcessor {
    public static void main(String[] args) {
        // You need to create a ResultSet object to use it
        // For demonstration purposes, I'll create a mock ResultSet
        ResultSet rs = new MockResultSet();

        Double d = null;
        try {
            d = (Double) rs.getObject(1);
        } catch (SQLException e) {
            System.out.println("Error getting object from ResultSet: " + e.getMessage());
        }

        if (d == null) {
            // do something else
            System.out.println("d is null");
        } else {
            // do something with d.doubleValue()
            System.out.println("d value: " + d.doubleValue());
        }
    }
}

// Mock ResultSet for demonstration purposes
class MockResultSet implements ResultSet {
    private Object[] values = new Object[] {10.5}; // Mock value

    @Override
    public Object getObject(int columnIndex) throws SQLException {
        return values[columnIndex - 1];
    }

    // Other ResultSet methods are not implemented for brevity
    @Override
    public boolean next() throws SQLException {
        return false;
    }

    @Override
    public void close() throws SQLException {}

    @Override
    public boolean wasNull() throws SQLException {
        return false;
    }

    // ... many other methods
}