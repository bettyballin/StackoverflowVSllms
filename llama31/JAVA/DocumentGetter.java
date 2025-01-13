import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentGetter {
    private String connectionString;

    public void getDocument(int documentID, int[] clientID, String[] documentName) {
        clientID[0] = 0;
        documentName[0] = "";

        try (Connection connection = DriverManager.getConnection(connectionString)) {
            try (PreparedStatement command = connection.prepareStatement("select ClientID, DocumentName from Document where DocumentID = ? and ClientID = ?")) {
                command.setInt(1, documentID);
                command.setInt(2, getCurrentClientID());

                try (ResultSet reader = command.executeQuery()) {
                    if (reader.next()) {
                        clientID[0] = reader.getInt(1);
                        documentName[0] = reader.getString(2);
                    }
                }
            }
        } catch (SQLException e) {
            // Handle SQL exception
        }
    }

    // Assume this method is implemented elsewhere
    private int getCurrentClientID() {
        // Implementation not provided
        return 0;
    }

    public static void main(String[] args) {
        DocumentGetter documentGetter = new DocumentGetter();
        documentGetter.connectionString = "your_database_connection_string";
        int[] clientID = new int[1];
        String[] documentName = new String[1];
        documentGetter.getDocument(1, clientID, documentName);
        System.out.println("Client ID: " + clientID[0]);
        System.out.println("Document Name: " + documentName[0]);
    }
}