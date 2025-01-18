import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import java.io.File;

public class ZIPCreateWithPassword {
    public static void main(String[] args) throws Exception {
        try {
            String source = "/path_to_your/source_file"; // replace with the proper source file path
            File outputZip = new File("/destination/zip_file.zip"); // replace with the desired zip file name and location

            ZipFile zip = new ZipFile(outputZip);
            zip.setFileNameCharset("CP866");
            String password = "YourPassword";   // your password

            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
            parameters.setEncryptFiles(true);
            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);  // or ENC_METHOD_AES
            parameters.setPassword(password);
            
            zip.addFile(new File(source), parameters);

        } catch (ZipException e) {
            throw new Exception(e.getMessage(), e);
        }
    }
}