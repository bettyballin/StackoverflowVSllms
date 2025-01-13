import java.lang.String;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PdfValidator {

    public static boolean isPdf(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] header = new byte[8];
            fis.read(header);
            return header[0] == 0x25 && header[1] == 0x50 && header[2] == 0x44 && header[3] == 0x46;
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("path/to/your/file.pdf");
        if (isPdf(file)) {
            System.out.println("File is a PDF");
        } else {
            System.out.println("File is not a PDF");
        }
    }
}