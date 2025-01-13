/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CsvExporter {
    int bufferSize = 32768;
    int chunkSize = 1000;

    public void exportCsv(ResultSet resultSet) throws SQLException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("fileName.csv");
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, this.bufferSize);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)bufferedOutputStream, StandardCharsets.ISO_8859_1);){
            while (resultSet.next()) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < this.chunkSize; ++i) {
                    stringBuilder.append(resultSet.getString(1)).append(",");
                    stringBuilder.append("\n");
                }
                outputStreamWriter.write(stringBuilder.toString());
                ((Writer)outputStreamWriter).flush();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] stringArray) {
    }
}
