import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.sql.*;

public class SQLToXMLConverter {
    public static void main(String[] args) {
        String url = "jdbc:yourdb://localhost/yourdatabase";
        String user = "username";
        String password = "password";
        String query = "SELECT * FROM your_table";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();

            try (XMLStreamWriter writer = outputFactory.createXMLStreamWriter(System.out)) {

                // Start document and root element
                writer.writeStartDocument("UTF-8", "1.0");
                writer.writeStartElement("Results");

                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (rs.next()) {
                    writer.writeStartElement("Row");

                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnName(i);
                        Object columnValue = rs.getObject(i);

                        // Write each column as a sub-element
                        writer.writeStartElement(columnName);
                        if (columnValue != null) {
                            writer.writeCharacters(columnValue.toString());
                        }
                        writer.writeEndElement();
                    }

                    writer.writeEndElement(); // Close Row element
                }

                // End root element and document
                writer.writeEndElement();
                writer.writeEndDocument();

                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}