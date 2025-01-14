import java.lang.String;
import java.io.File;
   import java.io.FileNotFoundException;
   import java.util.Scanner;

   public class ReadFile {
       public static void main(String[] args) {
           try (Scanner sc = new Scanner(new File("text.txt"))) {
               while (sc.hasNextLine()) {
                   String line = sc.nextLine();
                   System.out.println(line);
               }
           } catch (FileNotFoundException e) {
               System.out.println("An error occurred.");
               e.printStackTrace();
           }
       }
   }
