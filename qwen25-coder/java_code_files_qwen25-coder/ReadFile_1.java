import java.lang.String;
import java.io.File;
   import java.io.FileNotFoundException;
   import java.util.Scanner;

   public class ReadFile_1 {
       public static void main(String[] args) {
           if (args.length == 0) {
               System.out.println("Please provide a file path as an argument.");
               return;
           }

           String filePath = args[0];
           try (Scanner sc = new Scanner(new File(filePath))) {
               while (sc.hasNextLine()) {
                   String line = sc.nextLine();
                   System.out.println(line);
               }
           } catch (FileNotFoundException e) {
               System.out.println("The file does not exist.");
               e.printStackTrace();
           }
       }
   }
