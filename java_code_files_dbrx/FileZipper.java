import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import java.io.File;
import java.io.IOException;

public class FileZipper {
    public static void main(String[] args) throws IOException, ZipException {
        String password = "securePassword";
        String sourceFile = "file_to_zip.txt";
        String zipFilePath = "zipped_file.zip";
        
        ZipFile zipFile = new ZipFile(zipFilePath, password.toCharArray());
        zipFile.addFile(new File(sourceFile));
    }
}