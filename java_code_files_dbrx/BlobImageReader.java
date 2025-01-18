import java.sql.Blob;
import java.sql.ResultSet;

public class BlobImageReader {
    public static void main(String[] args) {
        ResultSet rs = null; // Placeholder for ResultSet

        try {
            Blob media = rs.getBlob("media_column"); // Retrieve image as binary large object.
            byte[] fileData = media.getBytes(1, (int) media.length()); // Read data from blob and convert it to bytes array.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}