import java.lang.String;
import java.io.*;
public class CountLines {
   public static void main(String[] args) throws IOException{
      File f = new File("file.txt");
      LineNumberReader lnr = new LineNumberReader(new FileReader(f));
      int linesCount = 0;
        while (lnr.readLine() != null){
            linesCount++;
    	}
    	System.out.println("Total number of Lines : " +linesCount);
   }
}