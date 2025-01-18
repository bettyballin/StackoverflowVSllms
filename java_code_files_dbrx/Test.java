import java.lang.String;
import java.io.*;
public class Test {
    public static void main(String[] args) throws IOException{
        String path = new File("").getAbsolutePath();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path + "\\Test.java")));
        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
            System.out.println(currentLine);
        }
    }
}