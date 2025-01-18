import java.lang.String;
import org.apache.tika.Tika;
import java.io.File;

public class FileTypeDetector {
   public static void main(String[] args) throws Exception {
      Tika tika = new Tika();
      String filePath1 = "/path/to/archive.rar"; // Replace with actual path to archive
      String filePath2 = "/path/to/plainText.txt"; // Replace with actual path to text file

      File file1 = new File(filePath1);
      File file2 = new File(filePath2);

      System.out.println("File 1 (Archive) MIME type: " + tika.detect(file1));
      System.out.println("File 2 (Text) MIME type:    " + tika.detect(file2));
   }
}