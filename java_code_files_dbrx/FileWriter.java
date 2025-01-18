import java.lang.String;
import java.io.IOException;
import java.nio.file.*;
public class FileWriter {
    public static void main(String[] args) throws IOException{
        Path path = Paths.get("C:\\myfolder\\myfile.txt");
        try {
            //try creating file and write something into it first
            Files.write(path, "Hello World!".getBytes());
            System.out.println("File is writable!");
            Files.deleteIfExists(path); //delete created file
        } catch (IOException e) {
            System.out.println("Cannot write to folder: "+e.getMessage());
        }
    }
}