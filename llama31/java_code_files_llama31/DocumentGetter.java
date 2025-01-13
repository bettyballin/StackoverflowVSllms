/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentGetter {
    private String connectionString;

    public void getDocument(int n, int[] nArray, String[] stringArray) {
        nArray[0] = 0;
        stringArray[0] = "";
        try (Connection connection = DriverManager.getConnection(this.connectionString);
             PreparedStatement preparedStatement = connection.prepareStatement("select ClientID, DocumentName from Document where DocumentID = ? and ClientID = ?");){
            preparedStatement.setInt(1, n);
            preparedStatement.setInt(2, this.getCurrentClientID());
            try (ResultSet resultSet = preparedStatement.executeQuery();){
                if (resultSet.next()) {
                    nArray[0] = resultSet.getInt(1);
                    stringArray[0] = resultSet.getString(2);
                }
            }
        }
        catch (SQLException sQLException) {
            // empty catch block
        }
    }

    private int getCurrentClientID() {
        return 0;
    }

    public static void main(String[] stringArray) {
        DocumentGetter documentGetter = new DocumentGetter();
        documentGetter.connectionString = "your_database_connection_string";
        int[] nArray = new int[1];
        String[] stringArray2 = new String[1];
        documentGetter.getDocument(1, nArray, stringArray2);
        System.out.println("Client ID: " + nArray[0]);
        System.out.println("Document Name: " + stringArray2[0]);
    }
}
