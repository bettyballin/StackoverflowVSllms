import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.File;

public class ZipWithPassword {
    public static void main(String[] args) throws ZipException {
        // Input file to be zipped
        String inputFilePath = "path/to/inputfile.txt";
        // Output zip file with password protection
        String outputZipFilePath = "path/to/outputfile.zip";
        // Password for the zip file
        String password = "yourPassword";

        // Create the zip file and add the input file with password protection
        ZipFile zipFile = new ZipFile(outputZipFilePath, password.toCharArray());
        zipFile.addFile(new File(inputFilePath));
    }
}