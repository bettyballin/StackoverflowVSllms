import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main_72 {
    public static void main(String[] args) {
        // Create a list of TableField objects
        List<TableField> arrayOfTablesObjects = new ArrayList<>();
        arrayOfTablesObjects.add(new TableField("table1", "field1"));
        arrayOfTablesObjects.add(new TableField("table2", "field2"));
        // Add more TableField objects as needed

        // Create a Connection object (replace with your actual database connection code)
        Connection conn = null;
        try {
            // Initialize with your database connection
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:example.db");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            return;
        }

        for (TableField tf : arrayOfTablesObjects) {
            String query = "UPDATE " + tf.getTableName() + " SET " + tf.getFieldName() + " = ? WHERE " + tf.getFieldName() + " = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, "xyz");
                stmt.setString(2, "123");
                stmt.executeUpdate();
            } catch (SQLException e) {
                // Handle exception
                System.out.println("Error updating table: " + e.getMessage());
            }
        }

        // Close the connection
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}

class TableField {
    private String tableName;
    private String fieldName;

    public TableField(String tableName, String fieldName) {
        this.tableName = tableName;
        this.fieldName = fieldName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}