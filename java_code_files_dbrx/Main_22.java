import java.lang.String;
import java.io.*;
public class Main_22 {
    public static void main(String[] args) throws IOException {
        String src = "/path/to/source";
        String dest = "/path/to/destination";
        File sourceFile = new File(src);
        File destinationFile;
        if (sourceFile.exists() && !sourceFile.isDirectory()) { // make sure the source file exists and is not a directory
            destinationFile = new File(dest);
             // check if the user has write permission to the destination path
            if (!destinationFile.canWrite()) {
                System.out.println("Insufficient permissions.");
                return;
            }
            sourceFile.renameTo(new File(dest)); // move file to new location, use copy for cross-partition move (see nio Copy API)
        } else {
             throw new IOException("Source not found or is a directory");
         }
    }
}