import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CsvExporter {

    // Define the buffer size and chunk size
    int bufferSize = 32768;
    int chunkSize = 1000;

    public void exportCsv(ResultSet resultSet) throws SQLException {
        try (FileOutputStream fos = new FileOutputStream("fileName.csv");
             BufferedOutputStream bos = new BufferedOutputStream(fos, bufferSize);
             Writer writer = new OutputStreamWriter(bos, StandardCharsets.ISO_8859_1)) {

            // Write in chunks
            while (resultSet.next()) {
                StringBuilder chunk = new StringBuilder();
                for (int i = 0; i < chunkSize; i++) {
                    // Append each record to the chunk
                    chunk.append(resultSet.getString(1)).append(",");
                    // ...
                    chunk.append("\n");
                }
                writer.write(chunk.toString());
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create an instance of CsvExporter and call the exportCsv method
        // with a valid ResultSet object
    }
}