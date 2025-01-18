import java.io.IOException;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

public class OSCommand {
    public static void main(String a[])
            throws IOException, InterruptedException {
        CommandLine cmd = new CommandLine("cmd"); //change this to your required executable file
        cmd.addArgument("/C", false); //this example is working with Windows so "/c" and "dir" are provided as arguments for windows command line interface CMD. You can change it according to the OS you want the code to run on along with your custom parameters if any
        cmd.addArgument("dir"); //change this to actual parameters of executable
        DefaultExecutor ex = new DefaultExecutor(); //creating object of Default Executor
        ex.execute(cmd);   //execution of commandline process
    }
}