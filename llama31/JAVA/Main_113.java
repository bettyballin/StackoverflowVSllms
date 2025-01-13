import oracle.sql.BFILE;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main_113 {
    public static void main(String[] args) throws IOException {
        // assume 'bfile' is the BFILE object and 'fileContents' is the uploaded file contents
        BFILE bfile = null; // Initialize with actual BFILE object
        byte[] fileContents = null; // Initialize with actual file contents

        // get the directory alias and file name from the BFILE object
        String directoryAlias = bfile.getDirAlias();
        String fileName = bfile.getName();

        // create a File object that represents the physical file
        File file = new File(directoryAlias + "/" + fileName);

        // write the file contents to disk
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(fileContents);
        }
    }
}