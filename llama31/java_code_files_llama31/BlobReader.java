/*
 * Decompiled with CFR 0.152.
 */
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BlobReader {
    public static void main(String[] stringArray) {
        ResultSet resultSet = null;
        try {
            byte[] byArray = resultSet.getBytes("blob_column");
            InputStream inputStream = resultSet.getBinaryStream("blob_column");
            Blob blob = resultSet.getBlob("blob_column");
            byte[] byArray2 = blob.getBytes(1L, (int)blob.length());
            InputStream inputStream2 = blob.getBinaryStream();
        }
        catch (SQLException sQLException) {
            System.err.println("Error accessing blob data: " + sQLException.getMessage());
        }
    }
}
