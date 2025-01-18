import java.lang.String;
import java.io.*;
public class Main_56 {
    public static void main(String[] args) throws IOException {
        File binDir = new File("../../../ggla/samples/obj"); // define the base directory using your input as reference
        System.out.println("Current path: " + binDir.getAbsolutePath());  // print working absolute filepath
        ProcessBuilder pb = new ProcessBuilder();//new process to run command
        pb.directory(binDir);     //set working directory for pb
        String[] cmdArray= {"/linux_x86"};    //define array with your executable filename
         try { //try catch block for running the execute method
             Process p = new ProcessBuilder(cmdArray).start();//create a process and start it
         } catch (IOException e) {
            System.out.println("Execution failed.");  //print message if execution fails
            throw new RuntimeException(e);   //throw exception
        }
    }
}