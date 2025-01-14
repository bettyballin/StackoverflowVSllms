import java.lang.String;
import java.io.IOException;

   public class SpawnProcess_1 {
       public static void main(String[] args) {
           try {
               // Command to execute your updater script wrapped with nohup and setsid for full detachment
               String command = "setsid /path/to/your/updater.sh";
               
               ProcessBuilder processBuilder = new ProcessBuilder("/bin/sh", "-c", command);
               processBuilder.start();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
