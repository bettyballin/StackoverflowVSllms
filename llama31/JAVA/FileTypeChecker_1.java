import java.lang.String;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileTypeChecker_1 {

    public static void main(String[] args) {
        File file = new File("path/to/your/file");

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] magicNumber = new byte[4];
            fis.read(magicNumber);

            if (magicNumber[0] == 0x50 && magicNumber[1] == 0x4B && magicNumber[2] == 0x03 && magicNumber[3] == 0x04) {
                System.out.println("File is a ZIP file");
            } else {
                System.out.println("File is not a ZIP file");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}