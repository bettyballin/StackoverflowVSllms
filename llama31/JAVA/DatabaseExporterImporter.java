import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseExporterImporter {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "myuser", "mypassword");
        TableDumper.dumpTable(conn, "mytable", new File("mytable.csv"));
        TableDumper.hydrateTable(conn, "mytable", new File("mytable.csv"));
    }
}