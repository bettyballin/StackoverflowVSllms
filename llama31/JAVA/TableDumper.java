import java.lang.String;
import java.sql.*;
import java.io.*;

public class TableDumper {
    public static void dumpTable(Connection conn, String tableName, File outputFile) throws SQLException, IOException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
        ResultSetMetaData metaData = rs.getMetaData();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                writer.write(metaData.getColumnName(i));
                if (i < metaData.getColumnCount()) {
                    writer.write(",");
                }
            }
            writer.newLine();

            while (rs.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    writer.write(rs.getString(i));
                    if (i < metaData.getColumnCount()) {
                        writer.write(",");
                    }
                }
                writer.newLine();
            }
        }
    }

    public static void hydrateTable(Connection conn, String tableName, File inputFile) throws SQLException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String[] columnNames = reader.readLine().split(",");
            String insertQuery = "INSERT INTO " + tableName + " (" + String.join(",", columnNames) + ") VALUES (" + String.join(",", new String[columnNames.length]).replace("null", "?") + ")";

            PreparedStatement pstmt = conn.prepareStatement(insertQuery);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                for (int i = 0; i < values.length; i++) {
                    pstmt.setString(i + 1, values[i]);
                }
                pstmt.executeUpdate();
            }
        }
    }

	public static void main(String[] args) {
	}
}