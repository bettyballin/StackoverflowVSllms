import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class PasswordProtectedZip {
    public static void main(String[] args) {
        String zipFile = "path/to/zipfile.zip";
        String password = "yourpassword";
        String fileToAdd = "path/to/file/to/add.txt";

        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setCompressionMethod(Zip4jConstants.COMP_METHOD_DEFLATE);
        zipParameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
        zipParameters.setEncryptFiles(true);
        zipParameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_ZIP_2_0);
        zipParameters.setPassword(password.toCharArray());

        try {
            ZipFile zip = new ZipFile(zipFile);
            zip.addFile(fileToAdd, zipParameters);
        } catch (Exception e) {
            System.out.println("Error creating zip file: " + e.getMessage());
        }
    }
}