import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.activation.DataHandler;
import org.apache.commons.io.IOUtils;

public class PdfToByteArrayConverter {
    public static void main(String[] args) {
        try {
            DataHandler dataHandler = null; // Initialize your DataHandler appropriately
            InputStream pdfInputStream = dataHandler.getDataSource().getInputStream(); // or get your PDF content in InputStream as convenient for DataHandler
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            IOUtils.copy(pdfInputStream, byteArrayOutputStream);
            byte[] bytes = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}