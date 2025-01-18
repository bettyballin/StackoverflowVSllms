import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileWriterExample {
    public static void main(String[] args) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("fileName.csv"));
             Writer writer = new OutputStreamWriter(bos)) {

            // Write your data here, for example looping through a result set
            ResultSet rs = null; // Initialize rs appropriately

            while(rs.next()){
                // Assuming you're using CSV format and there are 2 columns in each row:
                writer.write(rs.getString(1) + ",");
                writer.write(rs.getString(2) + "\n");
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}