import java.lang.String;
import java.io.File;
import java.nio.file.*;
public class Main_64 {
  public static void main(String[] args) throws Exception{
    String a = "dir1", b ="sub_dir1", c="sub_sub_dir1", d="myfile";
    Path directoryPath = FileSystems.getDefault().getPath("C:\\",a, b,c);  // specify final directory path
    Files.createDirectories(directoryPath);   // create the required directories if they don't exist
    Path filePath = new File(directoryPath+File.separator + d+".txt").toPath();  // build complete file path & name including extension .txt
    System.out.println("The created directory is: "+directoryPath);   // print the generated full directory path to console
  }
}