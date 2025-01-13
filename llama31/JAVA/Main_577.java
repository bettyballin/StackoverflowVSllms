import org.apache.ddlutils.model.Database;
import org.apache.ddlutils.model.Table;
import org.apache.ddlutils.model.Column;
import org.apache.ddlutils.Platform;
import org.apache.ddlutils.PlatformFactory;

public class Main_577 {
    public static void main(String[] args) {
        // Create a platform for the specific database type (e.g. MySQL, PostgreSQL, etc.)
        Platform platform = PlatformFactory.createNewPlatformInstance("mysql");

        // Create a database model from the database schema
        Database database = platform.readModelFromDatabase("my_schema");

        // Get the tables in the schema
        Table[] tables = database.getTables();

        // Iterate over the columns of a table
        Table myTable = tables[0];
        for (Column column : myTable.getColumns()) {
            System.out.println(column.getName() + ": " + column.getType());
        }

        // Add a new column to a table
        Column newColumn = new Column("my_new_column", "INTEGER");
        myTable.addColumn(newColumn);

        // Remove a column from a table
        Column columnToRemove = myTable.getColumn("my_column");
        myTable.removeColumn(columnToRemove);
    }
}