// Note: To compile and run this code, you need to have the following libraries in your classpath:
// 1. Apache Commons CSV (commons-csv-x.xx.jar)
// 2. HSQLDB JDBC driver (hsqldb-x.x.x.jar)

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CSVLoader {

    private final InMemoryHSQLDB dbSetup;
    private final String[] urls = {"url1", "url2", "url3"};

    public CSVLoader(InMemoryHSQLDB setup) {
        this.dbSetup = setup;
    }

    public void loadCSVData() throws IOException, SQLException {
        for (String url : urls) {
            loadURL(url);
        }
    }

    private void loadURL(String urlString) throws IOException, SQLException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        CSVParser parser = new CSVParser(
                new InputStreamReader(conn.getInputStream()),
                CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

        String tableName = getTableNameFromURL(urlString); // Define this method according to your needs

        try (PreparedStatement stmt = dbSetup.getConnection().prepareStatement(getInsertQuery(tableName, parser.getHeaderNames()))) {
            for (CSVRecord record : parser) {
                int idx = 1;
                for (String header : parser.getHeaderNames()) {
                    stmt.setString(idx++, record.get(header));
                }
                stmt.executeUpdate();
            }
        } finally {
            conn.disconnect();
            parser.close();
        }
    }

    private String getTableNameFromURL(String urlString) { // Logic based on your URL pattern
        return "Table1"; // Simplified, adapt this to get the correct table name.
    }

    private String getInsertQuery(String tableName, Iterable<String> headers) {
        StringBuilder fields = new StringBuilder();
        StringBuilder values = new StringBuilder();

        for (String header : headers) {
            if (fields.length() > 0) {
                fields.append(", ");
                values.append(", ");
            }
            fields.append(header);
            values.append("?");
        }

        return "INSERT INTO " + tableName + "(" + fields + ") VALUES (" + values + ")";
    }

    public static void main(String[] args) {
        try {
            InMemoryHSQLDB dbSetup = new InMemoryHSQLDB();
            CSVLoader loader = new CSVLoader(dbSetup);
            loader.loadCSVData();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

// Additional class

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class InMemoryHSQLDB {

    private Connection connection;

    public InMemoryHSQLDB() throws SQLException {
        // Create an in-memory HSQLDB connection
        connection = DriverManager.getConnection("jdbc:hsqldb:mem:mymemdb", "SA", "");
        initializeDatabase();
    }

    private void initializeDatabase() throws SQLException {
        // Create tables as required
        String createTableSQL = "CREATE TABLE Table1 (ID VARCHAR(255), NAME VARCHAR(255));"; // Simplified
        Statement stmt = connection.createStatement();
        stmt.execute(createTableSQL);
        stmt.close();
    }

    public Connection getConnection() {
        return connection;
    }
}