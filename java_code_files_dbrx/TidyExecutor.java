import java.lang.String;
import java.io.IOException;

public class TidyExecutor {
    // To run HTML Tidy from command line/terminal:
    public static void main(String[] args){
        String cmd = "cmd /c start"; //Change it according to your system, i.e., "/bin/bash" for linux systems
        try {
            Runtime.getRuntime().exec(cmd+" \"tidy -h\"");
        } catch (IOException e) {}
    }
}