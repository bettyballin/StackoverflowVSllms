import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class InsertSiteSupportDocs {
    public static void main(String[] args) throws Exception {
        String sql = "INSERT INTO site_support_docs "
               + "(ASSET_ID, TIME_STAMP, SITE_NAME, DOCUMENT_NAME, DOCUMENT_LOCATION, DOCUMENT_CONTENT, DOCUMENT_LAST_MODIFIED) "
               + "VALUES (?, ?, ?, ?, ?, ?, STR_TO_DATE(?, '%M %e, %Y %r')) "
               + "ON DUPLICATE KEY UPDATE asset_id = VALUES(asset_id),"
               + "                        time_stamp = VALUES(time_stamp),"
               + "                        site_name = VALUES(site_name),"
               + "                        document_name = VALUES(document_name),"
               + "                        document_location = VALUES(document_location),"
               + "                        document_content = VALUES(document_content),"
               + "                        document_last_modified = VALUES(document_last_modified)";

        // Assuming you have a database connection URL, username, and password
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        // Establish the database connection
        Connection conn = DriverManager.getConnection(url, username, password);

        // Prepare the statement
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // Define the variables used in the PreparedStatement
        String assetId = "asset123";
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        String siteName = "Example Site";
        String documentName = "Support Document";
        String documentLocation = "/docs/support_document.pdf";
        byte[] documentContent = new byte[]{/* your byte data */}; // or load from a file/input stream
        String documentLastModifiedStr = "October 3, 2023 12:00 AM";

        // Set the parameters
        pstmt.setString(1, assetId);
        pstmt.setTimestamp(2, timeStamp);
        pstmt.setString(3, siteName);
        pstmt.setString(4, documentName);
        pstmt.setString(5, documentLocation);
        pstmt.setBytes(6, documentContent); // or use setBlob depending on your data type
        pstmt.setString(7, documentLastModifiedStr);

        // Execute the update
        pstmt.executeUpdate();

        // Close the resources
        pstmt.close();
        conn.close();
    }
}