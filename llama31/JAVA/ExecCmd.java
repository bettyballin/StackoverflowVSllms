import java.lang.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecCmd {

public static void main(String[] args) {
    try {
        String command = "dir";
        Process child = Runtime.getRuntime().exec(command);

        // get output stream to write from it
        // PrintStream out = new PrintStream(child.getOutputStream());

        // get InputStream to read from it
        BufferedReader in = new BufferedReader(new InputStreamReader(child.getInputStream()));
        String s = null;
        while ((s = in.readLine()) != null) {
            System.out.println(s);
        }

        // write output
        // out.println("Hello");

    } catch (IOException e) {
        e.printStackTrace();
    }
}
}